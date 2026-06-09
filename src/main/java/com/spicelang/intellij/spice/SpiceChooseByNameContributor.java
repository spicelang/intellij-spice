/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Feeds Spice declarations into "Go to Symbol" (Ctrl+Alt+Shift+N).
 */
public class SpiceChooseByNameContributor implements ChooseByNameContributor {

    @Override
    public String @NotNull [] getNames(Project project, boolean includeNonProjectItems) {
        Set<String> names = new HashSet<>();
        for (SpiceSymbolUtil.Symbol symbol : SpiceSymbolUtil.findSymbols(project)) {
            names.add(symbol.name);
        }
        return names.toArray(new String[0]);
    }

    @Override
    public NavigationItem @NotNull [] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        List<NavigationItem> items = new ArrayList<>();
        for (SpiceSymbolUtil.Symbol symbol : SpiceSymbolUtil.findSymbols(project, name)) {
            items.add(new SymbolNavigationItem(symbol));
        }
        return items.toArray(new NavigationItem[0]);
    }

    private static final class SymbolNavigationItem implements NavigationItem {

        private final SpiceSymbolUtil.Symbol symbol;

        private SymbolNavigationItem(SpiceSymbolUtil.Symbol symbol) {
            this.symbol = symbol;
        }

        @Override
        public @NonNull String getName() {
            return symbol.name;
        }

        @Override
        public @NonNull ItemPresentation getPresentation() {
            PsiElement nameElement = symbol.nameElement;
            String location = nameElement.getContainingFile() != null ? nameElement.getContainingFile().getName() : null;
            return new PresentationData(symbol.name, location, SpiceSymbolUtil.iconFor(symbol.kind), null);
        }

        @Override
        public void navigate(boolean requestFocus) {
            VirtualFile virtualFile = virtualFile();
            if (virtualFile != null) {
                new OpenFileDescriptor(symbol.nameElement.getProject(), virtualFile,
                        symbol.nameElement.getTextRange().getStartOffset()).navigate(requestFocus);
            }
        }

        @Override
        public boolean canNavigate() {
            return virtualFile() != null;
        }

        @Override
        public boolean canNavigateToSource() {
            return canNavigate();
        }

        @Nullable
        private VirtualFile virtualFile() {
            return symbol.nameElement.getContainingFile() != null
                    ? symbol.nameElement.getContainingFile().getVirtualFile()
                    : null;
        }
    }
}
