// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceIfStmt extends PsiElement {

  @NotNull
  SpiceAssignExpr getAssignExpr();

  @Nullable
  SpiceElseStmt getElseStmt();

  @NotNull
  SpiceStmtLst getStmtLst();

}
