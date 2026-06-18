/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.run;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import com.intellij.openapi.util.NotNullLazyValue;
import com.spicelang.intellij.spice.SpiceIcons;

public class SpiceRunConfigurationType extends ConfigurationTypeBase {

    static final String ID = "SpiceRunConfiguration";

    public SpiceRunConfigurationType() {
        super(ID, "Spice", "Run a Spice program",
                NotNullLazyValue.createValue(() -> SpiceIcons.FILE));
        addFactory(new SpiceConfigurationFactory(this));
    }

    public static SpiceRunConfigurationType getInstance() {
        return ConfigurationTypeUtil.findConfigurationType(SpiceRunConfigurationType.class);
    }
}
