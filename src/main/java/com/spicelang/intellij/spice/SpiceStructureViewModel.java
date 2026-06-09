/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import com.spicelang.intellij.spice.psi.SpiceEnumDef;
import com.spicelang.intellij.spice.psi.SpiceFile;
import com.spicelang.intellij.spice.psi.SpiceInterfaceDef;
import com.spicelang.intellij.spice.psi.SpiceStructDef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpiceStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {

  public SpiceStructureViewModel(@Nullable Editor editor, PsiFile psiFile) {
    super(psiFile, editor, new SpiceStructureViewElement(psiFile));
  }

  @NotNull
  @Override
  public Sorter @NotNull [] getSorters() {
    return new Sorter[]{Sorter.ALPHA_SORTER};
  }

  @Override
  public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
    return false;
  }

  @Override
  public boolean isAlwaysLeaf(StructureViewTreeElement element) {
    Object value = element.getValue();
    // Only definitions that can contain members are expandable.
    return !(value instanceof SpiceFile
        || value instanceof SpiceStructDef
        || value instanceof SpiceInterfaceDef
        || value instanceof SpiceEnumDef);
  }
}
