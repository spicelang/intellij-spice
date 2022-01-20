// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceAtomicExpr extends PsiElement {

  @Nullable
  SpiceAssignExpr getAssignExpr();

  @Nullable
  SpiceBuiltinCall getBuiltinCall();

  @Nullable
  SpiceIdentifierExpr getIdentifierExpr();

  @Nullable
  SpiceValue getValue();

  //WARNING: getIdentifier(...) is skipped
  //matching getIdentifier(SpiceAtomicExpr, ...)
  //methods are not found in SpicePsiImplUtil

}
