// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceLambdaFunc extends PsiElement {

  @NotNull
  SpiceDataType getDataType();

  @Nullable
  SpiceLambdaAttr getLambdaAttr();

  @Nullable
  SpiceParamLst getParamLst();

  @NotNull
  SpiceStmtLst getStmtLst();

}
