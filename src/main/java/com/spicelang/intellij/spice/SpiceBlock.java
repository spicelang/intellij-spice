/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.ChildAttributes;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.Wrap;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import com.spicelang.intellij.spice.psi.SpiceTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SpiceBlock extends AbstractBlock {

    protected SpiceBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment) {
        super(node, wrap, alignment);
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        for (ASTNode child = myNode.getFirstChildNode(); child != null; child = child.getTreeNext()) {
            if (child.getElementType() == TokenType.WHITE_SPACE) continue;
            if (child.getText().isBlank()) continue;
            blocks.add(new SpiceBlock(child, null, null));
        }
        return blocks;
    }

    @Override
    public Indent getIndent() {
        ASTNode parent = myNode.getTreeParent();
        IElementType parentType = parent != null ? parent.getElementType() : null;
        IElementType type = myNode.getElementType();
        // Indent everything that lives directly inside a brace block, except the braces themselves.
        if (isBlockBody(parentType) && type != SpiceTypes.LBRACE && type != SpiceTypes.RBRACE) {
            return Indent.getNormalIndent();
        }
        return Indent.getNoneIndent();
    }

    @NotNull
    @Override
    public ChildAttributes getChildAttributes(int newChildIndex) {
        // Drives the indent of a freshly created line, e.g. after pressing Enter behind an opening brace.
        if (isBlockBody(myNode.getElementType())) {
            return new ChildAttributes(Indent.getNormalIndent(), null);
        }
        return new ChildAttributes(Indent.getNoneIndent(), null);
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

    private static boolean isBlockBody(@Nullable IElementType type) {
        return type == SpiceTypes.STMT_LST
                || type == SpiceTypes.STRUCT_DEF
                || type == SpiceTypes.INTERFACE_DEF
                || type == SpiceTypes.ENUM_DEF;
    }
}
