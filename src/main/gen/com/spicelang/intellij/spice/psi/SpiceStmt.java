// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceStmt extends PsiElement {

  @Nullable
  SpiceAssignExpr getAssignExpr();

  @Nullable
  SpiceBreakStmt getBreakStmt();

  @Nullable
  SpiceContinueStmt getContinueStmt();

  @Nullable
  SpiceDeclStmt getDeclStmt();

  @Nullable
  SpiceFallthroughStmt getFallthroughStmt();

  @Nullable
  SpiceReturnStmt getReturnStmt();

}
