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

public class SpiceStructDefImpl extends ASTWrapperPsiElement implements SpiceStructDef {

  public SpiceStructDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SpiceVisitor visitor) {
    visitor.visitStructDef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SpiceVisitor) accept((SpiceVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SpiceField> getFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceField.class);
  }

  @Override
  @Nullable
  public SpiceSpecifierLst getSpecifierLst() {
    return findChildByClass(SpiceSpecifierLst.class);
  }

  @Override
  @Nullable
  public SpiceTopLevelDefAttr getTopLevelDefAttr() {
    return findChildByClass(SpiceTopLevelDefAttr.class);
  }

  @Override
  @NotNull
  public List<SpiceTypeLst> getTypeLstList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SpiceTypeLst.class);
  }

}
