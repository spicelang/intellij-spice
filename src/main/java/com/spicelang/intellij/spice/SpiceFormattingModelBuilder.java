/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.formatting.FormattingContext;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.FormattingModelProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;

public class SpiceFormattingModelBuilder implements FormattingModelBuilder {

    @NotNull
    @Override
    public FormattingModel createModel(@NotNull FormattingContext context) {
        PsiElement element = context.getPsiElement();
        CodeStyleSettings settings = context.getCodeStyleSettings();
        SpiceBlock rootBlock = new SpiceBlock(element.getNode(), null, null);
        return FormattingModelProvider.createFormattingModelForPsiFile(
                element.getContainingFile(), rootBlock, settings);
    }
}
