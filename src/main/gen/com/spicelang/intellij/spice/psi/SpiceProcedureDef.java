// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceProcedureDef extends PsiElement {

  @NotNull
  SpiceFunctionName getFunctionName();

  @Nullable
  SpiceParamLst getParamLst();

  @Nullable
  SpiceSpecifierLst getSpecifierLst();

  @NotNull
  SpiceStmtLst getStmtLst();

  @Nullable
  SpiceTopLevelDefAttr getTopLevelDefAttr();

  @Nullable
  SpiceTypeLst getTypeLst();

}
