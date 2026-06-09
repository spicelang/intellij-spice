/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.spicelang.intellij.spice.psi.SpiceTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SpiceFoldingBuilder extends FoldingBuilderEx implements DumbAware {

    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root,
                                                          @NotNull Document document,
                                                          boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        appendDescriptors(root.getNode(), document, descriptors);
        return descriptors.toArray(FoldingDescriptor.EMPTY_ARRAY);
    }

    private void appendDescriptors(@NotNull ASTNode node,
                                   @NotNull Document document,
                                   @NotNull List<FoldingDescriptor> descriptors) {
        IElementType type = node.getElementType();
        if (type == SpiceTypes.STMT_LST) {
            // Function / loop / conditional bodies and anonymous blocks: the element already spans { ... }.
            addDescriptor(node, node.getTextRange(), document, descriptors);
        } else if (type == SpiceTypes.STRUCT_DEF || type == SpiceTypes.INTERFACE_DEF || type == SpiceTypes.ENUM_DEF) {
            // Fold only the brace block, keeping the "type Foo struct" header visible.
            TextRange range = braceRange(node);
            if (range != null) addDescriptor(node, range, document, descriptors);
        } else if (type == SpiceTypes.BLOCK_COMMENT || type == SpiceTypes.DOC_COMMENT) {
            addDescriptor(node, node.getTextRange(), document, descriptors);
        }

        for (ASTNode child = node.getFirstChildNode(); child != null; child = child.getTreeNext()) {
            appendDescriptors(child, document, descriptors);
        }
    }

    private static @Nullable TextRange braceRange(@NotNull ASTNode node) {
        ASTNode lBrace = node.findChildByType(SpiceTypes.LBRACE);
        ASTNode rBrace = node.findChildByType(SpiceTypes.RBRACE);
        if (lBrace == null || rBrace == null) return null;
        return new TextRange(lBrace.getStartOffset(), rBrace.getStartOffset() + rBrace.getTextLength());
    }

    private static void addDescriptor(@NotNull ASTNode node,
                                      @NotNull TextRange range,
                                      @NotNull Document document,
                                      @NotNull List<FoldingDescriptor> descriptors) {
        if (range.getLength() <= 0) return;
        // Only fold regions that actually span more than one line.
        int startLine = document.getLineNumber(range.getStartOffset());
        int endLine = document.getLineNumber(range.getEndOffset() - 1);
        if (endLine > startLine) {
            descriptors.add(new FoldingDescriptor(node, range));
        }
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        IElementType type = node.getElementType();
        if (type == SpiceTypes.DOC_COMMENT) return "/**...*/";
        if (type == SpiceTypes.BLOCK_COMMENT) return "/*...*/";
        return "{...}";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
