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

public class SpiceBuiltinCallImpl extends ASTWrapperPsiElement implements SpiceBuiltinCall {

  public SpiceBuiltinCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SpiceVisitor visitor) {
    visitor.visitBuiltinCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SpiceVisitor) accept((SpiceVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SpiceJoinCall getJoinCall() {
    return findChildByClass(SpiceJoinCall.class);
  }

  @Override
  @Nullable
  public SpiceLenCall getLenCall() {
    return findChildByClass(SpiceLenCall.class);
  }

  @Override
  @Nullable
  public SpicePrintfCall getPrintfCall() {
    return findChildByClass(SpicePrintfCall.class);
  }

  @Override
  @Nullable
  public SpiceSizeOfCall getSizeOfCall() {
    return findChildByClass(SpiceSizeOfCall.class);
  }

  @Override
  @Nullable
  public SpiceTidCall getTidCall() {
    return findChildByClass(SpiceTidCall.class);
  }

}
