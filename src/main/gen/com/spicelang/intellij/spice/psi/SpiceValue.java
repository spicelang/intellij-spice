// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceValue extends PsiElement {

  @Nullable
  SpiceDataType getDataType();

  @NotNull
  List<SpiceIdentifierExpr> getIdentifierExprList();

  @Nullable
  SpiceParamLst getParamLst();

  @Nullable
  SpicePrimitiveValue getPrimitiveValue();

}
