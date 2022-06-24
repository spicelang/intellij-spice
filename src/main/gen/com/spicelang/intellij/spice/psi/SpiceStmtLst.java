// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceStmtLst extends PsiElement {

  @NotNull
  List<SpiceAssertStmt> getAssertStmtList();

  @NotNull
  List<SpiceForLoop> getForLoopList();

  @NotNull
  List<SpiceForeachLoop> getForeachLoopList();

  @NotNull
  List<SpiceIfStmt> getIfStmtList();

  @NotNull
  List<SpiceStmt> getStmtList();

  @NotNull
  List<SpiceThreadDef> getThreadDefList();

  @NotNull
  List<SpiceUnsafeBlockDef> getUnsafeBlockDefList();

  @NotNull
  List<SpiceWhileLoop> getWhileLoopList();

}
