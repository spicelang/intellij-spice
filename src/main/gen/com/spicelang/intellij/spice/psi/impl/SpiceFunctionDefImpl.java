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

public class SpiceFunctionDefImpl extends ASTWrapperPsiElement implements SpiceFunctionDef {

  public SpiceFunctionDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SpiceVisitor visitor) {
    visitor.visitFunctionDef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SpiceVisitor) accept((SpiceVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SpiceArgLstDef getArgLstDef() {
    return findChildByClass(SpiceArgLstDef.class);
  }

  @Override
  @NotNull
  public SpiceDataType getDataType() {
    return findNotNullChildByClass(SpiceDataType.class);
  }

  @Override
  @Nullable
  public SpiceDeclSpecifiers getDeclSpecifiers() {
    return findChildByClass(SpiceDeclSpecifiers.class);
  }

  @Override
  @NotNull
  public List<SpiceIdentifierExpr> getIdentifierExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceIdentifierExpr.class);
  }

  @Override
  @NotNull
  public SpiceStmtLst getStmtLst() {
    return findNotNullChildByClass(SpiceStmtLst.class);
  }

  @Override
  @Nullable
  public SpiceTemplateDef getTemplateDef() {
    return findChildByClass(SpiceTemplateDef.class);
  }

}
