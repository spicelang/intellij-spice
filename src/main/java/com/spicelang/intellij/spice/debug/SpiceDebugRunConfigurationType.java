/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.debug;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import com.intellij.openapi.util.NotNullLazyValue;
import com.spicelang.intellij.spice.SpiceIcons;

public class SpiceDebugRunConfigurationType extends ConfigurationTypeBase {

    static final String ID = "SpiceDebugRunConfiguration";

    public SpiceDebugRunConfigurationType() {
        super(ID, "Spice (Native)", "Build, run and debug a native Spice executable with GDB",
                NotNullLazyValue.createValue(() -> SpiceIcons.FILE));
        addFactory(new SpiceDebugConfigurationFactory(this));
    }

    public static SpiceDebugRunConfigurationType getInstance() {
        return ConfigurationTypeUtil.findConfigurationType(SpiceDebugRunConfigurationType.class);
    }
}
