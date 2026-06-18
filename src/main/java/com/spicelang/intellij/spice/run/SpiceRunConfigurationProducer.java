/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.run;

import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.actions.LazyRunConfigurationProducer;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.spicelang.intellij.spice.psi.SpiceFile;
import org.jetbrains.annotations.NotNull;

public class SpiceRunConfigurationProducer extends LazyRunConfigurationProducer<SpiceRunConfiguration> {

    @NotNull
    @Override
    public ConfigurationFactory getConfigurationFactory() {
        return SpiceRunConfigurationType.getInstance().getConfigurationFactories()[0];
    }

    @Override
    protected boolean setupConfigurationFromContext(@NotNull SpiceRunConfiguration configuration,
                                                    @NotNull ConfigurationContext context,
                                                    @NotNull Ref<PsiElement> sourceElement) {
        VirtualFile file = getSpiceFile(context);
        if (file == null) {
            return false;
        }
        configuration.setSourceFilePath(file.getPath());
        configuration.setName("Run " + file.getName());
        return true;
    }

    @Override
    public boolean isConfigurationFromContext(@NotNull SpiceRunConfiguration configuration,
                                              @NotNull ConfigurationContext context) {
        VirtualFile file = getSpiceFile(context);
        return file != null && file.getPath().equals(configuration.getSourceFilePath());
    }

    private static VirtualFile getSpiceFile(@NotNull ConfigurationContext context) {
        PsiElement location = context.getPsiLocation();
        if (location == null) {
            return null;
        }
        PsiFile psiFile = location.getContainingFile();
        if (!(psiFile instanceof SpiceFile)) {
            return null;
        }
        return psiFile.getVirtualFile();
    }
}
