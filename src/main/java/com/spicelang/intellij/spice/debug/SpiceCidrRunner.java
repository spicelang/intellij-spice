/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.debug;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ui.RunContentDescriptor;
import com.jetbrains.cidr.execution.CidrCommandLineState;
import com.jetbrains.cidr.execution.CidrRunner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Program runner that handles both the Run and Debug executors for {@link SpiceDebugRunConfiguration}.
 * For Debug it starts a native (GDB) debug session via the bundled native debugger; for Run it executes
 * the produced {@link CidrCommandLineState} like any other process.
 */
public class SpiceCidrRunner extends CidrRunner {

    @NotNull
    @Override
    public String getRunnerId() {
        return "SpiceCidrRunner";
    }

    @Override
    public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
        if (!(profile instanceof SpiceDebugRunConfiguration)) {
            return false;
        }
        return DefaultDebugExecutor.EXECUTOR_ID.equals(executorId)
                || DefaultRunExecutor.EXECUTOR_ID.equals(executorId);
    }

    @Nullable
    @Override
    protected RunContentDescriptor doExecute(@NotNull RunProfileState state,
                                             @NotNull ExecutionEnvironment environment) throws ExecutionException {
        boolean isDebug = DefaultDebugExecutor.EXECUTOR_ID.equals(environment.getExecutor().getId());
        if (isDebug && state instanceof CidrCommandLineState) {
            return startDebugDescriptor((CidrCommandLineState) state, environment, false);
        }
        return super.doExecute(state, environment);
    }
}
