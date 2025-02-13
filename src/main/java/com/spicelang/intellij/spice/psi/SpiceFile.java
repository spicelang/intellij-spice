/*
 * Copyright (c) 2022-2025 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.spicelang.intellij.spice.SpiceFileType;
import com.spicelang.intellij.spice.SpiceLanguage;
import org.jetbrains.annotations.NotNull;

public class SpiceFile extends PsiFileBase {
    public SpiceFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SpiceLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return SpiceFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Spice File";
    }
}
