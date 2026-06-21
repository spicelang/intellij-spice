/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.debug;

import com.intellij.execution.Executor;
import com.intellij.execution.configuration.EnvironmentVariablesData;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationBase;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.configurations.RuntimeConfigurationError;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.jetbrains.cidr.execution.CidrCommandLineState;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Run/Debug configuration that builds a Spice program with {@code spice build -g} and runs or
 * debugs the produced native executable through the bundled native (GDB) debugger.
 */
public class SpiceDebugRunConfiguration extends RunConfigurationBase<SpiceDebugRunConfigurationOptions> {

    protected SpiceDebugRunConfiguration(@NotNull Project project, @NotNull ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @NotNull
    @Override
    protected SpiceDebugRunConfigurationOptions getOptions() {
        return (SpiceDebugRunConfigurationOptions) super.getOptions();
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

    public String getBuildArguments() {
        return getOptions().getBuildArguments();
    }

    public void setBuildArguments(String arguments) {
        getOptions().setBuildArguments(arguments);
    }

    public String getProgramArguments() {
        return getOptions().getProgramArguments();
    }

    public void setProgramArguments(String arguments) {
        getOptions().setProgramArguments(arguments);
    }

    public String getGdbExecutablePath() {
        return getOptions().getGdbExecutablePath();
    }

    public void setGdbExecutablePath(String path) {
        getOptions().setGdbExecutablePath(path);
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
        return new SpiceDebugSettingsEditor();
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        if (StringUtil.isEmptyOrSpaces(getSpiceExecutablePath())) {
            throw new RuntimeConfigurationError("No Spice compiler specified");
        }
        if (StringUtil.isEmptyOrSpaces(getSourceFilePath())) {
            throw new RuntimeConfigurationError("No Spice source file specified");
        }
        if (!new File(getSourceFilePath()).isFile()) {
            throw new RuntimeConfigurationError("Spice source file does not exist: " + getSourceFilePath());
        }
    }

    @NotNull
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) {
        return new CidrCommandLineState(environment, new SpiceDebugLauncher(this));
    }
}
