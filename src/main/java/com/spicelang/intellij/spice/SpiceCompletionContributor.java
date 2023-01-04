/*
 * Copyright (c) 2022-2023 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.spicelang.intellij.spice.psi.SpiceTypes;
import org.jetbrains.annotations.NotNull;

public class SpiceCompletionContributor extends CompletionContributor {
    public SpiceCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(SpiceTypes.IDENTIFIER), new CompletionProvider<>() {
            public void addCompletions(@NotNull CompletionParameters parameters,
                                       @NotNull ProcessingContext context,
                                       @NotNull CompletionResultSet resultSet) {
                resultSet.addElement(LookupElementBuilder.create("Hello"));
            }
        });
    }
}
