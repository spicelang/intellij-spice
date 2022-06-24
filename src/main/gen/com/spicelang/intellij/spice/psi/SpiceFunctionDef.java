// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceFunctionDef extends PsiElement {

  @Nullable
  SpiceArgLstDef getArgLstDef();

  @NotNull
  SpiceDataType getDataType();

  @Nullable
  SpiceDeclSpecifiers getDeclSpecifiers();

  @NotNull
  List<SpiceIdentifierExpr> getIdentifierExprList();

  @NotNull
  SpiceStmtLst getStmtLst();

}
