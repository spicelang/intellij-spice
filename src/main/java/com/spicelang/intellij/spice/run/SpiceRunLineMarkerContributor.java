/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.run;

import com.intellij.execution.lineMarker.ExecutorAction;
import com.intellij.execution.lineMarker.RunLineMarkerContributor;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.spicelang.intellij.spice.psi.SpiceMainFunctionDef;
import com.spicelang.intellij.spice.psi.SpiceTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Shows a run gutter icon next to the {@code main} keyword of every main function definition.
 */
public class SpiceRunLineMarkerContributor extends RunLineMarkerContributor {

    @Nullable
    @Override
    public Info getInfo(@NotNull PsiElement element) {
        // Anchor on the `main` keyword leaf so a single icon is rendered on the signature line.
        if (element.getNode().getElementType() != SpiceTypes.MAIN) {
            return null;
        }
        if (PsiTreeUtil.getParentOfType(element, SpiceMainFunctionDef.class) == null) {
            return null;
        }

        AnAction[] actions = ExecutorAction.getActions(0);
        return new Info(AllIcons.RunConfigurations.TestState.Run, actions,
                e -> "Run Spice program");
    }
}
