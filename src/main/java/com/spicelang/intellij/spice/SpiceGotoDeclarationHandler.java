/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.spicelang.intellij.spice.psi.SpiceDeclStmt;
import com.spicelang.intellij.spice.psi.SpiceFile;
import com.spicelang.intellij.spice.psi.SpiceTypes;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Resolves an identifier under the caret (Ctrl+B / Ctrl+click) to its declaration(s).
 *
 * <p>This is a name-based resolver: it does not yet model scopes or types, so it returns every
 * declaration in the project that shares the identifier's simple name, preferring local
 * declarations of the current file first.
 */
public class SpiceGotoDeclarationHandler implements GotoDeclarationHandler {

    @Override
    public PsiElement @Nullable [] getGotoDeclarationTargets(@Nullable PsiElement sourceElement, int offset, Editor editor) {
        if (sourceElement == null) return null;
        ASTNode node = sourceElement.getNode();
        if (node == null) return null;
        IElementType type = node.getElementType();
        if (type != SpiceTypes.IDENTIFIER && type != SpiceTypes.TYPE_IDENTIFIER) return null;

        PsiFile file = sourceElement.getContainingFile();
        if (!(file instanceof SpiceFile)) return null;

        String name = sourceElement.getText();
        Project project = sourceElement.getProject();

        Set<PsiElement> targets = new LinkedHashSet<>();

        // 1) Local declarations (parameters and local variables) within the current file.
        for (SpiceDeclStmt declStmt : PsiTreeUtil.findChildrenOfType(file, SpiceDeclStmt.class)) {
            ASTNode identifier = declStmt.getNode().findChildByType(SpiceTypes.IDENTIFIER);
            if (identifier != null && name.equals(identifier.getText())) {
                targets.add(identifier.getPsi());
            }
        }

        // 2) Top-level and member declarations of the current file (index-independent, so this
        //    works even when the file is not in an indexed content root or the index is cold) ...
        for (SpiceSymbolUtil.Symbol symbol : SpiceSymbolUtil.findSymbols(file)) {
            if (name.equals(symbol.name)) targets.add(symbol.nameElement);
        }
        // 3) ... and the same declarations across the rest of the project.
        for (SpiceSymbolUtil.Symbol symbol : SpiceSymbolUtil.findSymbols(project, name)) {
            targets.add(symbol.nameElement);
        }

        // Don't resolve an identifier to itself.
        targets.remove(sourceElement);
        if (targets.isEmpty()) return null;
        return targets.toArray(PsiElement.EMPTY_ARRAY);
    }
}
