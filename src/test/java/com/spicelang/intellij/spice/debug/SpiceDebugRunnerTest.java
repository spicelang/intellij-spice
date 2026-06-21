/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.debug;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

/**
 * Verifies the runner's executor matching logic. This is independent of the optional native-debug
 * module being loaded (the headless test product disables the bundled native debugger, so the
 * extension-point registration itself cannot be exercised here).
 */
public class SpiceDebugRunnerTest extends BasePlatformTestCase {

    public void testRunnerAcceptsRunAndDebugForNativeConfig() {
        SpiceDebugRunConfigurationType type = new SpiceDebugRunConfigurationType();
        RunConfiguration config = type.getConfigurationFactories()[0].createTemplateConfiguration(getProject());

        SpiceCidrRunner runner = new SpiceCidrRunner();
        assertTrue("must handle the Debug executor",
                runner.canRun(DefaultDebugExecutor.EXECUTOR_ID, config));
        assertTrue("must handle the Run executor",
                runner.canRun(DefaultRunExecutor.EXECUTOR_ID, config));
    }

    public void testRunnerRejectsUnrelatedConfigs() {
        SpiceCidrRunner runner = new SpiceCidrRunner();
        com.spicelang.intellij.spice.run.SpiceRunConfigurationType unrelatedType =
                new com.spicelang.intellij.spice.run.SpiceRunConfigurationType();
        RunConfiguration unrelated = unrelatedType.getConfigurationFactories()[0].createTemplateConfiguration(getProject());
        assertFalse("must not handle the plain (spice run) configuration type",
                runner.canRun(DefaultDebugExecutor.EXECUTOR_ID, unrelated));
    }
}
