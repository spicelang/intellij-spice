/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.spicelang.intellij.spice.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Collects the named, top-level (and member) declarations of Spice files. Shared by the
 * go-to-symbol contributor and the go-to-declaration handler.
 */
public final class SpiceSymbolUtil {

    public enum Kind {FUNCTION, PROCEDURE, STRUCT, INTERFACE, ENUM, ENUM_ITEM, FIELD, SIGNATURE, GLOBAL_VAR, ALIAS, GENERIC_TYPE}

    /** A named declaration: its simple name, the identifier leaf to navigate to, and what kind it is. */
    public static final class Symbol {
        public final String name;
        public final PsiElement nameElement;
        public final Kind kind;

        Symbol(@NotNull String name, @NotNull PsiElement nameElement, @NotNull Kind kind) {
            this.name = name;
            this.nameElement = nameElement;
            this.kind = kind;
        }
    }

    private SpiceSymbolUtil() {
    }

    public static @NotNull List<Symbol> findSymbols(@NotNull Project project) {
        List<Symbol> result = new ArrayList<>();
        Collection<VirtualFile> files = FileTypeIndex.getFiles(SpiceFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : files) {
            PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
            if (psiFile instanceof SpiceFile) collectSymbols((SpiceFile) psiFile, result);
        }
        return result;
    }

    /** Collects symbols from a single file directly, without relying on the (possibly cold) file index. */
    public static @NotNull List<Symbol> findSymbols(@NotNull PsiFile file) {
        List<Symbol> result = new ArrayList<>();
        if (file instanceof SpiceFile) collectSymbols((SpiceFile) file, result);
        return result;
    }

    public static @NotNull List<Symbol> findSymbols(@NotNull Project project, @NotNull String name) {
        List<Symbol> result = new ArrayList<>();
        for (Symbol symbol : findSymbols(project)) {
            if (symbol.name.equals(name)) result.add(symbol);
        }
        return result;
    }

    private static void collectSymbols(@NotNull SpiceFile file, @NotNull List<Symbol> out) {
        // Each kind is collected independently with a deep search, so a single malformed node
        // (or an unexpected nesting) cannot prevent the remaining declarations from being found.
        for (SpiceFunctionDef def : PsiTreeUtil.findChildrenOfType(file, SpiceFunctionDef.class)) {
            addToken(out, def.getFunctionName(), SpiceTypes.IDENTIFIER, Kind.FUNCTION);
        }
        for (SpiceProcedureDef def : PsiTreeUtil.findChildrenOfType(file, SpiceProcedureDef.class)) {
            addToken(out, def.getFunctionName(), SpiceTypes.IDENTIFIER, Kind.PROCEDURE);
        }
        for (SpiceStructDef def : PsiTreeUtil.findChildrenOfType(file, SpiceStructDef.class)) {
            addToken(out, def, SpiceTypes.TYPE_IDENTIFIER, Kind.STRUCT);
        }
        for (SpiceInterfaceDef def : PsiTreeUtil.findChildrenOfType(file, SpiceInterfaceDef.class)) {
            addToken(out, def, SpiceTypes.TYPE_IDENTIFIER, Kind.INTERFACE);
        }
        for (SpiceEnumDef def : PsiTreeUtil.findChildrenOfType(file, SpiceEnumDef.class)) {
            addToken(out, def, SpiceTypes.TYPE_IDENTIFIER, Kind.ENUM);
        }
        for (SpiceGlobalVarDef def : PsiTreeUtil.findChildrenOfType(file, SpiceGlobalVarDef.class)) {
            addToken(out, def, SpiceTypes.TYPE_IDENTIFIER, Kind.GLOBAL_VAR);
        }
        for (SpiceAliasDef def : PsiTreeUtil.findChildrenOfType(file, SpiceAliasDef.class)) {
            addToken(out, def, SpiceTypes.TYPE_IDENTIFIER, Kind.ALIAS);
        }
        for (SpiceGenericTypeDef def : PsiTreeUtil.findChildrenOfType(file, SpiceGenericTypeDef.class)) {
            addToken(out, def, SpiceTypes.TYPE_IDENTIFIER, Kind.GENERIC_TYPE);
        }
        for (SpiceField field : PsiTreeUtil.findChildrenOfType(file, SpiceField.class)) {
            addToken(out, field, SpiceTypes.IDENTIFIER, Kind.FIELD);
        }
        for (SpiceSignature signature : PsiTreeUtil.findChildrenOfType(file, SpiceSignature.class)) {
            addToken(out, signature, SpiceTypes.IDENTIFIER, Kind.SIGNATURE);
        }
        for (SpiceEnumItem item : PsiTreeUtil.findChildrenOfType(file, SpiceEnumItem.class)) {
            addToken(out, item, SpiceTypes.TYPE_IDENTIFIER, Kind.ENUM_ITEM);
        }
    }

    private static void addToken(@NotNull List<Symbol> out, @Nullable PsiElement parent, @NotNull IElementType type, @NotNull Kind kind) {
        if (parent == null) return;
        ASTNode node = parent.getNode().findChildByType(type);
        if (node == null) return;
        out.add(new Symbol(node.getText(), node.getPsi(), kind));
    }

    public static @NotNull Icon iconFor(@NotNull Kind kind) {
        return switch (kind) {
            case FUNCTION, PROCEDURE -> AllIcons.Nodes.Method;
            case SIGNATURE -> AllIcons.Nodes.AbstractMethod;
            case STRUCT, ALIAS, GENERIC_TYPE -> AllIcons.Nodes.Class;
            case INTERFACE -> AllIcons.Nodes.Interface;
            case ENUM -> AllIcons.Nodes.Enum;
            case ENUM_ITEM -> AllIcons.Nodes.Constant;
            case FIELD -> AllIcons.Nodes.Field;
            case GLOBAL_VAR -> AllIcons.Nodes.Gvariable;
        };
    }
}
