// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.spicelang.intellij.spice.psi.SpiceTypes.*;
import com.spicelang.intellij.spice.psi.*;

public class SpiceIdentifierExprImpl extends SpiceNamedElementImpl implements SpiceIdentifierExpr {

  public SpiceIdentifierExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SpiceVisitor visitor) {
    visitor.visitIdentifierExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SpiceVisitor) accept((SpiceVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getIdentifier() {
    return SpicePsiImplUtil.getIdentifier(this);
  }

  @Override
  public String getName() {
    return SpicePsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return SpicePsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return SpicePsiImplUtil.getNameIdentifier(this);
  }

}
