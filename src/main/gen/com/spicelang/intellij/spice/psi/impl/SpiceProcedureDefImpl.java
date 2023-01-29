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

public class SpiceProcedureDefImpl extends ASTWrapperPsiElement implements SpiceProcedureDef {

  public SpiceProcedureDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SpiceVisitor visitor) {
    visitor.visitProcedureDef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SpiceVisitor) accept((SpiceVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SpiceFunctionName getFunctionName() {
    return findNotNullChildByClass(SpiceFunctionName.class);
  }

  @Override
  @Nullable
  public SpiceParamLst getParamLst() {
    return findChildByClass(SpiceParamLst.class);
  }

  @Override
  @Nullable
  public SpiceSpecifierLst getSpecifierLst() {
    return findChildByClass(SpiceSpecifierLst.class);
  }

  @Override
  @NotNull
  public SpiceStmtLst getStmtLst() {
    return findNotNullChildByClass(SpiceStmtLst.class);
  }

  @Override
  @Nullable
  public SpiceTypeLst getTypeLst() {
    return findChildByClass(SpiceTypeLst.class);
  }

}
