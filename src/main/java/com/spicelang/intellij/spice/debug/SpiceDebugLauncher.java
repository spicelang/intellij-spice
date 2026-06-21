/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.debug;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.CapturingProcessHandler;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessOutput;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.execution.ParametersListUtil;
import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugSession;
import com.jetbrains.cidr.execution.CidrLauncher;
import com.jetbrains.cidr.execution.RunParameters;
import com.jetbrains.cidr.execution.TrivialInstaller;
import com.jetbrains.cidr.execution.TrivialRunParameters;
import com.jetbrains.cidr.execution.debugger.CidrLocalDebugProcess;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * Drives the lifecycle of a {@link SpiceDebugRunConfiguration}: it first compiles the program with
 * {@code spice build -g} and then either launches the produced executable (Run) or attaches the
 * native GDB debugger to it (Debug).
 */
public class SpiceDebugLauncher extends CidrLauncher {

    private static final long BUILD_TIMEOUT_MS = 600_000L;

    private final SpiceDebugRunConfiguration configuration;

    public SpiceDebugLauncher(@NotNull SpiceDebugRunConfiguration configuration) {
        this.configuration = configuration;
    }

    @NotNull
    @Override
    public Project getProject() {
        return configuration.getProject();
    }

    @NotNull
    @Override
    protected ProcessHandler createProcess(@NotNull CommandLineState state) throws ExecutionException {
        File executable = buildExecutable();
        OSProcessHandler processHandler = new OSProcessHandler(createRunCommandLine(executable));
        ProcessTerminatedListener.attach(processHandler, getProject());
        return processHandler;
    }

    @NotNull
    @Override
    protected XDebugProcess createDebugProcess(@NotNull CommandLineState state,
                                               @NotNull XDebugSession session) throws ExecutionException {
        // The build runs on this (background) thread so it does not freeze the UI, but the debug
        // process itself must be constructed on the EDT (CidrDebugProcess asserts this).
        File executable = buildExecutable();
        GeneralCommandLine runCommandLine = createRunCommandLine(executable);
        RunParameters parameters = new TrivialRunParameters(
                new SpiceGDBDriverConfiguration(configuration.getGdbExecutablePath()),
                new TrivialInstaller(runCommandLine));

        Ref<CidrLocalDebugProcess> process = Ref.create();
        Ref<ExecutionException> failure = Ref.create();
        ApplicationManager.getApplication().invokeAndWait(() -> {
            try {
                process.set(new CidrLocalDebugProcess(parameters, session, state.getConsoleBuilder()));
            } catch (ExecutionException e) {
                failure.set(e);
            }
        }, ModalityState.any());
        if (!failure.isNull()) {
            throw failure.get();
        }
        return process.get();
    }

    /**
     * Compiles the configured Spice program with debug info and returns the produced executable.
     */
    @NotNull
    private File buildExecutable() throws ExecutionException {
        File sourceFile = new File(configuration.getSourceFilePath());
        File workingDirectory = sourceFile.getParentFile();
        File executable = new File(workingDirectory, baseName(sourceFile.getName()));

        String compiler = StringUtil.defaultIfEmpty(configuration.getSpiceExecutablePath().trim(), "spice");
        GeneralCommandLine buildCommandLine = new GeneralCommandLine(compiler, "build", "-g");
        String buildArguments = configuration.getBuildArguments();
        if (!StringUtil.isEmptyOrSpaces(buildArguments)) {
            buildCommandLine.addParameters(ParametersListUtil.parse(buildArguments));
        }
        buildCommandLine.addParameters("-o", executable.getAbsolutePath());
        buildCommandLine.addParameter(sourceFile.getAbsolutePath());
        buildCommandLine.setWorkDirectory(workingDirectory);
        buildCommandLine.withCharset(StandardCharsets.UTF_8);

        ProcessOutput output = new CapturingProcessHandler(buildCommandLine).runProcess((int) BUILD_TIMEOUT_MS);
        if (output.isTimeout()) {
            throw new ExecutionException("Timed out while building the Spice program with '" + compiler + " build'");
        }
        if (output.getExitCode() != 0) {
            throw new ExecutionException("Building the Spice program failed (exit code " + output.getExitCode() + "):\n"
                    + output.getStdout() + output.getStderr());
        }
        if (!executable.isFile()) {
            throw new ExecutionException("The Spice build did not produce an executable at " + executable.getAbsolutePath());
        }
        return executable;
    }

    @NotNull
    private GeneralCommandLine createRunCommandLine(@NotNull File executable) {
        GeneralCommandLine commandLine = new GeneralCommandLine(executable.getAbsolutePath());
        commandLine.setWorkDirectory(executable.getParentFile());
        String programArguments = configuration.getProgramArguments();
        if (!StringUtil.isEmptyOrSpaces(programArguments)) {
            commandLine.addParameters(ParametersListUtil.parse(programArguments));
        }
        configuration.getEnvironmentVariables().configureCommandLine(commandLine, false);
        commandLine.withCharset(StandardCharsets.UTF_8);
        return commandLine;
    }

    @NotNull
    private static String baseName(@NotNull String fileName) {
        int dot = fileName.lastIndexOf('.');
        return dot > 0 ? fileName.substring(0, dot) : fileName;
    }
}
