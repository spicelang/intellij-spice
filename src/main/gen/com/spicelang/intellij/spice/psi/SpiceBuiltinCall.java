// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceBuiltinCall extends PsiElement {

  @Nullable
  SpiceJoinCall getJoinCall();

  @Nullable
  SpiceLenCall getLenCall();

  @Nullable
  SpicePrintfCall getPrintfCall();

  @Nullable
  SpiceSizeOfCall getSizeOfCall();

  @Nullable
  SpiceTidCall getTidCall();

}
