// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceStructDef extends PsiElement {

  @NotNull
  List<SpiceField> getFieldList();

  @Nullable
  SpiceSpecifierLst getSpecifierLst();

  @Nullable
  SpiceTopLevelDefAttr getTopLevelDefAttr();

  @NotNull
  List<SpiceTypeLst> getTypeLstList();

}
