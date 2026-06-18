/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.run;

import com.intellij.execution.configuration.EnvironmentVariablesComponent;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class SpiceSettingsEditor extends SettingsEditor<SpiceRunConfiguration> {

    private final JPanel panel;
    private final JBTextField executableField = new JBTextField();
    private final TextFieldWithBrowseButton sourceFileField = new TextFieldWithBrowseButton();
    private final JBTextField argumentsField = new JBTextField();
    private final EnvironmentVariablesComponent environmentVariablesComponent = new EnvironmentVariablesComponent();

    public SpiceSettingsEditor() {
        FileChooserDescriptor descriptor = FileChooserDescriptorFactory
                .createSingleFileNoJarsDescriptor()
                .withTitle("Select Spice Source File")
                .withFileFilter(file -> "spice".equalsIgnoreCase(file.getExtension()));
        sourceFileField.addBrowseFolderListener(null, descriptor);

        panel = FormBuilder.createFormBuilder()
                .addLabeledComponent("Spice executable", executableField)
                .addLabeledComponent("Main source file", sourceFileField)
                .addLabeledComponent("Program arguments", argumentsField)
                .addComponent(environmentVariablesComponent)
                .getPanel();
    }

    @Override
    protected void resetEditorFrom(@NotNull SpiceRunConfiguration configuration) {
        executableField.setText(configuration.getSpiceExecutablePath());
        sourceFileField.setText(configuration.getSourceFilePath());
        argumentsField.setText(configuration.getProgramArguments());
        environmentVariablesComponent.setEnvData(configuration.getEnvironmentVariables());
    }

    @Override
    protected void applyEditorTo(@NotNull SpiceRunConfiguration configuration) {
        configuration.setSpiceExecutablePath(executableField.getText());
        configuration.setSourceFilePath(sourceFileField.getText());
        configuration.setProgramArguments(argumentsField.getText());
        configuration.setEnvironmentVariables(environmentVariablesComponent.getEnvData());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return panel;
    }
}
