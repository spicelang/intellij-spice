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

public class SpiceAssignExprImpl extends ASTWrapperPsiElement implements SpiceAssignExpr {

  public SpiceAssignExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SpiceVisitor visitor) {
    visitor.visitAssignExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SpiceVisitor) accept((SpiceVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SpiceAssignExpr getAssignExpr() {
    return findChildByClass(SpiceAssignExpr.class);
  }

  @Override
  @Nullable
  public SpiceAssignOp getAssignOp() {
    return findChildByClass(SpiceAssignOp.class);
  }

  @Override
  @Nullable
  public SpicePrefixUnaryExpr getPrefixUnaryExpr() {
    return findChildByClass(SpicePrefixUnaryExpr.class);
  }

  @Override
  @Nullable
  public SpiceTernaryExpr getTernaryExpr() {
    return findChildByClass(SpiceTernaryExpr.class);
  }

  @Override
  @Nullable
  public SpiceThreadDef getThreadDef() {
    return findChildByClass(SpiceThreadDef.class);
  }

}
