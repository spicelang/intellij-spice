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

public class SpiceStmtImpl extends ASTWrapperPsiElement implements SpiceStmt {

  public SpiceStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SpiceVisitor visitor) {
    visitor.visitStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SpiceVisitor) accept((SpiceVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SpiceArrayInitStmt getArrayInitStmt() {
    return findChildByClass(SpiceArrayInitStmt.class);
  }

  @Override
  @Nullable
  public SpiceAssignExpr getAssignExpr() {
    return findChildByClass(SpiceAssignExpr.class);
  }

  @Override
  @Nullable
  public SpiceBreakStmt getBreakStmt() {
    return findChildByClass(SpiceBreakStmt.class);
  }

  @Override
  @Nullable
  public SpiceBuiltinCall getBuiltinCall() {
    return findChildByClass(SpiceBuiltinCall.class);
  }

  @Override
  @Nullable
  public SpiceContinueStmt getContinueStmt() {
    return findChildByClass(SpiceContinueStmt.class);
  }

  @Override
  @Nullable
  public SpiceDeclStmt getDeclStmt() {
    return findChildByClass(SpiceDeclStmt.class);
  }

  @Override
  @Nullable
  public SpiceIdenValue getIdenValue() {
    return findChildByClass(SpiceIdenValue.class);
  }

  @Override
  @Nullable
  public SpiceNewStmt getNewStmt() {
    return findChildByClass(SpiceNewStmt.class);
  }

  @Override
  @Nullable
  public SpiceReturnStmt getReturnStmt() {
    return findChildByClass(SpiceReturnStmt.class);
  }

}
