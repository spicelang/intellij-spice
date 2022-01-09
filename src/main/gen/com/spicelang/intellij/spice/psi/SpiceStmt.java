// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceStmt extends PsiElement {

  @Nullable
  SpiceArrayInitStmt getArrayInitStmt();

  @Nullable
  SpiceAssignExpr getAssignExpr();

  @Nullable
  SpiceBreakStmt getBreakStmt();

  @Nullable
  SpiceBuiltinCall getBuiltinCall();

  @Nullable
  SpiceContinueStmt getContinueStmt();

  @Nullable
  SpiceDeclStmt getDeclStmt();

  @Nullable
  SpiceIdenValue getIdenValue();

  @Nullable
  SpiceNewStmt getNewStmt();

  @Nullable
  SpiceReturnStmt getReturnStmt();

}
