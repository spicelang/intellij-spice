/*
 * Copyright (c) 2022-2025 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.spicelang.intellij.spice.psi.SpiceIdentifierExpr;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SpiceReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String identifier;

    public SpiceReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        identifier = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @NotNull
    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<SpiceIdentifierExpr> identifiers = SpiceUtil.findIdentifiers(project, identifier);
        List<ResolveResult> results = new ArrayList<>();
        for (SpiceIdentifierExpr property : identifiers) {
            results.add(new PsiElementResolveResult(property));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Override
    public @Nullable PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        List<SpiceIdentifierExpr> spiceIdentifierExpressions = SpiceUtil.findIdentifiers(project);
        List<LookupElement> variants = new ArrayList<>();
        for (final SpiceIdentifierExpr spiceIdentifierExpr : spiceIdentifierExpressions) {
            if (spiceIdentifierExpr.getIdentifier() != null && spiceIdentifierExpr.getIdentifier().length() > 0) {
                variants.add(LookupElementBuilder
                        .create(spiceIdentifierExpr).withIcon(SpiceIcons.FILE)
                        .withTypeText(spiceIdentifierExpr.getContainingFile().getName()));
            }
        }
        return variants.toArray();
    }
}
