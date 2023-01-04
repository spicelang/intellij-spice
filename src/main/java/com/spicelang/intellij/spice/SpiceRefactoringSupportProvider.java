/*
 * Copyright (c) 2022-2023 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.spicelang.intellij.spice.psi.SpiceIdentifierExpr;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpiceRefactoringSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement elementToRename, @Nullable PsiElement context) {
        return (elementToRename instanceof SpiceIdentifierExpr);
    }
}
