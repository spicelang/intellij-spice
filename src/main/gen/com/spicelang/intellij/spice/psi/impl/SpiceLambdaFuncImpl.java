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

public class SpiceLambdaFuncImpl extends ASTWrapperPsiElement implements SpiceLambdaFunc {

  public SpiceLambdaFuncImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SpiceVisitor visitor) {
    visitor.visitLambdaFunc(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SpiceVisitor) accept((SpiceVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SpiceDataType getDataType() {
    return findNotNullChildByClass(SpiceDataType.class);
  }

  @Override
  @Nullable
  public SpiceLambdaAttr getLambdaAttr() {
    return findChildByClass(SpiceLambdaAttr.class);
  }

  @Override
  @Nullable
  public SpiceParamLst getParamLst() {
    return findChildByClass(SpiceParamLst.class);
  }

  @Override
  @NotNull
  public SpiceStmtLst getStmtLst() {
    return findNotNullChildByClass(SpiceStmtLst.class);
  }

}
