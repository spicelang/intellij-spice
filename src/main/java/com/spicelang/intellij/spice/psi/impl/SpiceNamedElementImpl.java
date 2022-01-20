package com.spicelang.intellij.spice.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.spicelang.intellij.spice.psi.SpiceNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class SpiceNamedElementImpl extends ASTWrapperPsiElement implements SpiceNamedElement {
    public SpiceNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
