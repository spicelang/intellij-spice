/*
 * Copyright (c) 2022-2024 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.psi;

import com.intellij.psi.tree.IElementType;
import com.spicelang.intellij.spice.SpiceLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SpiceElementType extends IElementType {
    public SpiceElementType(@NotNull @NonNls String debugName) {
        super(debugName, SpiceLanguage.INSTANCE);
    }
}
