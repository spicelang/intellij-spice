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

public class SpiceStmtLstImpl extends ASTWrapperPsiElement implements SpiceStmtLst {

  public SpiceStmtLstImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SpiceVisitor visitor) {
    visitor.visitStmtLst(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SpiceVisitor) accept((SpiceVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SpiceAnonymousBlockStmt> getAnonymousBlockStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceAnonymousBlockStmt.class);
  }

  @Override
  @NotNull
  public List<SpiceAssertStmt> getAssertStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceAssertStmt.class);
  }

  @Override
  @NotNull
  public List<SpiceDoWhileLoop> getDoWhileLoopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceDoWhileLoop.class);
  }

  @Override
  @NotNull
  public List<SpiceForLoop> getForLoopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceForLoop.class);
  }

  @Override
  @NotNull
  public List<SpiceForeachLoop> getForeachLoopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceForeachLoop.class);
  }

  @Override
  @NotNull
  public List<SpiceIfStmt> getIfStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceIfStmt.class);
  }

  @Override
  @NotNull
  public List<SpiceStmt> getStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceStmt.class);
  }

  @Override
  @NotNull
  public List<SpiceSwitchStmt> getSwitchStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceSwitchStmt.class);
  }

  @Override
  @NotNull
  public List<SpiceUnsafeBlock> getUnsafeBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceUnsafeBlock.class);
  }

  @Override
  @NotNull
  public List<SpiceWhileLoop> getWhileLoopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceWhileLoop.class);
  }

}
