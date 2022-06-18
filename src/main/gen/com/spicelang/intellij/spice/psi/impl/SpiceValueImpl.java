// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.spicelang.intellij.spice.psi.SpiceTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.spicelang.intellij.spice.psi.*;

public class SpiceValueImpl extends ASTWrapperPsiElement implements SpiceValue {

  public SpiceValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SpiceVisitor visitor) {
    visitor.visitValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SpiceVisitor) accept((SpiceVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SpiceArgLst getArgLst() {
    return findChildByClass(SpiceArgLst.class);
  }

  @Override
  @Nullable
  public SpiceDataType getDataType() {
    return findChildByClass(SpiceDataType.class);
  }

  @Override
  @NotNull
  public List<SpiceIdentifierExpr> getIdentifierExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceIdentifierExpr.class);
  }

  @Override
  @Nullable
  public SpicePrimitiveValue getPrimitiveValue() {
    return findChildByClass(SpicePrimitiveValue.class);
  }

  @Override
  @Nullable
  public SpiceTypeLst getTypeLst() {
    return findChildByClass(SpiceTypeLst.class);
  }

}
