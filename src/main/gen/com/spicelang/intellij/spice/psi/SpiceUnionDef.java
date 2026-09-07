// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceUnionDef extends PsiElement {

  @NotNull
  List<SpiceField> getFieldList();

  @Nullable
  SpiceSpecifierLst getSpecifierLst();

  @Nullable
  SpiceTopLevelDefAttr getTopLevelDefAttr();

  @Nullable
  SpiceTypeLst getTypeLst();

}
