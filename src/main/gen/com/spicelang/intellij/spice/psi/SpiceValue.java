// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceValue extends PsiElement {

  @Nullable
  SpiceArrayInitialization getArrayInitialization();

  @Nullable
  SpiceConstant getConstant();

  @Nullable
  SpiceDataType getDataType();

  @Nullable
  SpiceFunctionCall getFunctionCall();

  @Nullable
  SpiceStructInstantiation getStructInstantiation();

}
