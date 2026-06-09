/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.spicelang.intellij.spice.psi.SpiceTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpiceBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] PAIRS = new BracePair[]{
            new BracePair(SpiceTypes.LBRACE, SpiceTypes.RBRACE, true),
            new BracePair(SpiceTypes.LPAREN, SpiceTypes.RPAREN, false),
            new BracePair(SpiceTypes.LBRACKET, SpiceTypes.RBRACKET, false),
    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
