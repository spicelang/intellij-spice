// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceStmtLst extends PsiElement {

  @NotNull
  List<SpiceAnonymousBlockStmt> getAnonymousBlockStmtList();

  @NotNull
  List<SpiceAssertStmt> getAssertStmtList();

  @NotNull
  List<SpiceDoWhileLoop> getDoWhileLoopList();

  @NotNull
  List<SpiceForLoop> getForLoopList();

  @NotNull
  List<SpiceForeachLoop> getForeachLoopList();

  @NotNull
  List<SpiceIfStmt> getIfStmtList();

  @NotNull
  List<SpiceStmt> getStmtList();

  @NotNull
  List<SpiceSwitchStmt> getSwitchStmtList();

  @NotNull
  List<SpiceUnsafeBlock> getUnsafeBlockList();

  @NotNull
  List<SpiceWhileLoop> getWhileLoopList();

}
