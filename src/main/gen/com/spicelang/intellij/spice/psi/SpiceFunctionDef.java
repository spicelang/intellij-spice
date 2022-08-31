// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceFunctionDef extends PsiElement {

  @NotNull
  SpiceDataType getDataType();

  @NotNull
  List<SpiceIdentifierExpr> getIdentifierExprList();

  @Nullable
  SpiceParamLst getParamLst();

  @Nullable
  SpiceSpecifierLst getSpecifierLst();

  @NotNull
  SpiceStmtLst getStmtLst();

  @Nullable
  SpiceTypeLst getTypeLst();

}
