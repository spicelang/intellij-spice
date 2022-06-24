// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpicePostfixUnaryExpr extends PsiElement {

  @NotNull
  List<SpiceArgLst> getArgLstList();

  @NotNull
  List<SpiceAssignExpr> getAssignExprList();

  @NotNull
  SpiceAtomicExpr getAtomicExpr();

  @NotNull
  List<SpicePostfixUnaryExpr> getPostfixUnaryExprList();

}
