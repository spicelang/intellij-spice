/*
 * Copyright (c) 2022-2025 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.psi;

import com.intellij.psi.tree.IElementType;
import com.spicelang.intellij.spice.SpiceLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SpiceTokenType extends IElementType {
    public SpiceTokenType(@NotNull @NonNls String debugName) {
        super(debugName, SpiceLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SpiceTokenType." + super.toString();
    }
}
