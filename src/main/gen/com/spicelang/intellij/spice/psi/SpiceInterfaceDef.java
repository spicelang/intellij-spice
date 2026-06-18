// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SpiceInterfaceDef extends PsiElement {

  @Nullable
  SpiceQualifierLst getQualifierLst();

  @NotNull
  List<SpiceSignature> getSignatureList();

  @Nullable
  SpiceTopLevelDefAttr getTopLevelDefAttr();

  @Nullable
  SpiceTypeLst getTypeLst();

}
