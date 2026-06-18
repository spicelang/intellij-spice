/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationBase;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import com.intellij.execution.configuration.EnvironmentVariablesData;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.execution.ParametersListUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class SpiceRunConfiguration extends RunConfigurationBase<SpiceRunConfigurationOptions> {

    protected SpiceRunConfiguration(@NotNull Project project, @NotNull ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @NotNull
    @Override
    protected SpiceRunConfigurationOptions getOptions() {
        return (SpiceRunConfigurationOptions) super.getOptions();
    }

    public String getSpiceExecutablePath() {
        return getOptions().getSpiceExecutablePath();
    }

    public void setSpiceExecutablePath(String path) {
        getOptions().setSpiceExecutablePath(path);
    }

    public String getSourceFilePath() {
        return getOptions().getSourceFilePath();
    }

    public void setSourceFilePath(String path) {
        getOptions().setSourceFilePath(path);
    }

    public String getProgramArguments() {
        return getOptions().getProgramArguments();
    }

    public void setProgramArguments(String arguments) {
        getOptions().setProgramArguments(arguments);
    }

    public EnvironmentVariablesData getEnvironmentVariables() {
        return EnvironmentVariablesData.create(
                getOptions().getEnvironmentVariables(),
                getOptions().isPassParentEnvironmentVariables());
    }

    public void setEnvironmentVariables(EnvironmentVariablesData environmentVariables) {
        getOptions().setEnvironmentVariables(environmentVariables.getEnvs());
        getOptions().setPassParentEnvironmentVariables(environmentVariables.isPassParentEnvs());
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new SpiceSettingsEditor();
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        if (StringUtil.isEmptyOrSpaces(getSpiceExecutablePath())) {
            throw new RuntimeConfigurationException("No Spice executable specified");
        }
        if (StringUtil.isEmptyOrSpaces(getSourceFilePath())) {
            throw new RuntimeConfigurationException("No Spice source file specified");
        }
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) {
        return new CommandLineState(environment) {
            @NotNull
            @Override
            protected ProcessHandler startProcess() throws ExecutionException {
                String executable = StringUtil.defaultIfEmpty(getSpiceExecutablePath(), "spice");
                GeneralCommandLine commandLine = new GeneralCommandLine(executable, "run");

                String sourceFilePath = getSourceFilePath();
                if (!StringUtil.isEmptyOrSpaces(sourceFilePath)) {
                    commandLine.addParameter(sourceFilePath);

                    File parentDir = new File(sourceFilePath).getParentFile();
                    if (parentDir != null && parentDir.isDirectory()) {
                        commandLine.setWorkDirectory(parentDir);
                    }
                }

                String programArguments = getProgramArguments();
                if (!StringUtil.isEmptyOrSpaces(programArguments)) {
                    commandLine.addParameters(ParametersListUtil.parse(programArguments));
                }

                getEnvironmentVariables().configureCommandLine(commandLine, false);

                commandLine.withCharset(java.nio.charset.StandardCharsets.UTF_8);

                OSProcessHandler processHandler = new OSProcessHandler(commandLine);
                ProcessTerminatedListener.attach(processHandler);
                return processHandler;
            }
        };
    }
}
