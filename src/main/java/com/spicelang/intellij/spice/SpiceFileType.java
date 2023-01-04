/*
 * Copyright (c) 2022-2023 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class SpiceFileType extends LanguageFileType {

    public static final SpiceFileType INSTANCE = new SpiceFileType();

    private SpiceFileType() {
        super(SpiceLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Spice File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Spice language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "spice";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SpiceIcons.FILE;
    }

}