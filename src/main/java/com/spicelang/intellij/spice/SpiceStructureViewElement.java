/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.spicelang.intellij.spice.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SpiceStructureViewElement implements StructureViewTreeElement, SortableTreeElement {

  private final NavigatablePsiElement element;

  public SpiceStructureViewElement(NavigatablePsiElement element) {
    this.element = element;
  }

  @Override
  public Object getValue() {
    return element;
  }

  @Override
  public void navigate(boolean requestFocus) {
    element.navigate(requestFocus);
  }

  @Override
  public boolean canNavigate() {
    return element.canNavigate();
  }

  @Override
  public boolean canNavigateToSource() {
    return element.canNavigateToSource();
  }

  @NotNull
  @Override
  public String getAlphaSortKey() {
    return getPresentableText(element);
  }

  @NotNull
  @Override
  public ItemPresentation getPresentation() {
    return new PresentationData(getPresentableText(element), null, getElementIcon(element), null);
  }

  @Override
  public TreeElement @NotNull [] getChildren() {
    List<PsiElement> children = new ArrayList<>();
    if (element instanceof SpiceFile) {
      // getChildren() returns only composite child nodes, i.e. the top-level definitions.
      for (PsiElement child : element.getChildren()) {
        if (isStructuralTopLevel(child)) children.add(child);
      }
    } else if (element instanceof SpiceStructDef) {
      children.addAll(((SpiceStructDef) element).getFieldList());
    } else if (element instanceof SpiceInterfaceDef) {
      children.addAll(((SpiceInterfaceDef) element).getSignatureList());
    } else if (element instanceof SpiceEnumDef) {
      children.addAll(((SpiceEnumDef) element).getEnumItemLst().getEnumItemList());
    }

    List<TreeElement> result = new ArrayList<>(children.size());
    for (PsiElement child : children) {
      if (child instanceof NavigatablePsiElement) {
        result.add(new SpiceStructureViewElement((NavigatablePsiElement) child));
      }
    }
    return result.toArray(TreeElement.EMPTY_ARRAY);
  }

  private static boolean isStructuralTopLevel(PsiElement element) {
    return element instanceof SpiceMainFunctionDef
        || element instanceof SpiceFunctionDef
        || element instanceof SpiceProcedureDef
        || element instanceof SpiceStructDef
        || element instanceof SpiceInterfaceDef
        || element instanceof SpiceEnumDef
        || element instanceof SpiceGenericTypeDef
        || element instanceof SpiceAliasDef
        || element instanceof SpiceGlobalVarDef;
  }

  @NotNull
  private static String getPresentableText(PsiElement element) {
    if (element instanceof SpiceFile) return ((SpiceFile) element).getName();
    if (element instanceof SpiceMainFunctionDef) return "main()";
    if (element instanceof SpiceFunctionDef) return ((SpiceFunctionDef) element).getFunctionName().getText() + "()";
    if (element instanceof SpiceProcedureDef) return ((SpiceProcedureDef) element).getFunctionName().getText() + "()";
    if (element instanceof SpiceSignature) return tokenText(element, SpiceTypes.IDENTIFIER) + "()";
    if (element instanceof SpiceField) return tokenText(element, SpiceTypes.IDENTIFIER);
    // structs, interfaces, enums, enum items, generic types, aliases and global vars are all named via a TYPE_IDENTIFIER.
    return tokenText(element, SpiceTypes.TYPE_IDENTIFIER);
  }

  @NotNull
  private static String tokenText(PsiElement element, IElementType type) {
    ASTNode node = element.getNode().findChildByType(type);
    return node != null ? node.getText() : element.getText();
  }

  private static @NonNull Icon getElementIcon(PsiElement element) {
    if (element instanceof SpiceFile) return SpiceIcons.FILE;
    if (element instanceof SpiceMainFunctionDef) return AllIcons.Nodes.Method;
    if (element instanceof SpiceFunctionDef) return AllIcons.Nodes.Method;
    if (element instanceof SpiceProcedureDef) return AllIcons.Nodes.Method;
    if (element instanceof SpiceSignature) return AllIcons.Nodes.AbstractMethod;
    if (element instanceof SpiceStructDef) return AllIcons.Nodes.Class;
    if (element instanceof SpiceInterfaceDef) return AllIcons.Nodes.Interface;
    if (element instanceof SpiceEnumDef) return AllIcons.Nodes.Enum;
    if (element instanceof SpiceEnumItem) return AllIcons.Nodes.Constant;
    if (element instanceof SpiceField) return AllIcons.Nodes.Field;
    if (element instanceof SpiceGlobalVarDef) return AllIcons.Nodes.Gvariable;
    if (element instanceof SpiceGenericTypeDef) return AllIcons.Nodes.Class;
    if (element instanceof SpiceAliasDef) return AllIcons.Nodes.Class;
    return AllIcons.Nodes.Tag;
  }
}
