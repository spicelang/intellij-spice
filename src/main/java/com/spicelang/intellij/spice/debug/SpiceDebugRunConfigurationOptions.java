/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.debug;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

import java.util.Map;

public class SpiceDebugRunConfigurationOptions extends RunConfigurationOptions {

    private final StoredProperty<String> spiceExecutablePath =
            string("spice").provideDelegate(this, "spiceExecutablePath");
    private final StoredProperty<String> sourceFilePath =
            string("").provideDelegate(this, "sourceFilePath");
    private final StoredProperty<String> buildArguments =
            string("").provideDelegate(this, "buildArguments");
    private final StoredProperty<String> programArguments =
            string("").provideDelegate(this, "programArguments");
    private final StoredProperty<String> gdbExecutablePath =
            string("").provideDelegate(this, "gdbExecutablePath");
    private final StoredProperty<Map<String, String>> environmentVariables =
            this.<String, String>linkedMap().provideDelegate(this, "environmentVariables");
    private final StoredProperty<Boolean> passParentEnvironmentVariables =
            property(true).provideDelegate(this, "passParentEnvironmentVariables");

    public String getSpiceExecutablePath() {
        return spiceExecutablePath.getValue(this);
    }

    public void setSpiceExecutablePath(String value) {
        spiceExecutablePath.setValue(this, value);
    }

    public String getSourceFilePath() {
        return sourceFilePath.getValue(this);
    }

    public void setSourceFilePath(String value) {
        sourceFilePath.setValue(this, value);
    }

    public String getBuildArguments() {
        return buildArguments.getValue(this);
    }

    public void setBuildArguments(String value) {
        buildArguments.setValue(this, value);
    }

    public String getProgramArguments() {
        return programArguments.getValue(this);
    }

    public void setProgramArguments(String value) {
        programArguments.setValue(this, value);
    }

    public String getGdbExecutablePath() {
        return gdbExecutablePath.getValue(this);
    }

    public void setGdbExecutablePath(String value) {
        gdbExecutablePath.setValue(this, value);
    }

    public Map<String, String> getEnvironmentVariables() {
        return environmentVariables.getValue(this);
    }

    public void setEnvironmentVariables(Map<String, String> value) {
        environmentVariables.setValue(this, value);
    }

    public boolean isPassParentEnvironmentVariables() {
        return passParentEnvironmentVariables.getValue(this);
    }

    public void setPassParentEnvironmentVariables(boolean value) {
        passParentEnvironmentVariables.setValue(this, value);
    }
}
