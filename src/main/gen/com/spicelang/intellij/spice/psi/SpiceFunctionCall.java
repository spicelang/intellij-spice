// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceFunctionCall extends PsiElement {

  @Nullable
  SpiceArgLst getArgLst();

  @NotNull
  SpiceIdentifierExpr getIdentifierExpr();

  @Nullable
  SpiceTypeLst getTypeLst();

}
