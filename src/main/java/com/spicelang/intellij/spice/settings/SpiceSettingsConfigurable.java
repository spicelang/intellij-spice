/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.settings;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.components.JBCheckBox;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Settings page under Settings | Languages &amp; Frameworks | Spice.
 */
public class SpiceSettingsConfigurable implements Configurable {

    private TextFieldWithBrowseButton compilerPathField;
    private JBCheckBox useSpiceFormatterCheckBox;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Spice";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        compilerPathField = new TextFieldWithBrowseButton();
        compilerPathField.addBrowseFolderListener(null, FileChooserDescriptorFactory
                .createSingleFileNoJarsDescriptor()
                .withTitle("Select Spice Compiler"));
        useSpiceFormatterCheckBox = new JBCheckBox("Use 'spice format' to reformat Spice files");

        return FormBuilder.createFormBuilder()
                .addLabeledComponent("Spice compiler:", compilerPathField)
                .addTooltip("Leave empty to use '" + SpiceSettings.DEFAULT_COMPILER + "' from the PATH")
                .addComponent(useSpiceFormatterCheckBox)
                .addTooltip("Requires a Spice compiler, that provides the 'format' subcommand")
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    @Override
    public boolean isModified() {
        SpiceSettings settings = SpiceSettings.getInstance();
        return !compilerPathField.getText().trim().equals(settings.getCompilerPath())
                || useSpiceFormatterCheckBox.isSelected() != settings.isUseSpiceFormatter();
    }

    @Override
    public void apply() {
        SpiceSettings settings = SpiceSettings.getInstance();
        settings.setCompilerPath(compilerPathField.getText());
        settings.setUseSpiceFormatter(useSpiceFormatterCheckBox.isSelected());
    }

    @Override
    public void reset() {
        SpiceSettings settings = SpiceSettings.getInstance();
        compilerPathField.setText(settings.getCompilerPath());
        useSpiceFormatterCheckBox.setSelected(settings.isUseSpiceFormatter());
    }

    @Override
    public void disposeUIResources() {
        compilerPathField = null;
        useSpiceFormatterCheckBox = null;
    }
}
