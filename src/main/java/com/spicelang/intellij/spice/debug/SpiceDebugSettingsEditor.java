/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.debug;

import com.intellij.execution.configuration.EnvironmentVariablesComponent;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class SpiceDebugSettingsEditor extends SettingsEditor<SpiceDebugRunConfiguration> {

    private final JPanel panel;
    private final TextFieldWithBrowseButton compilerField = new TextFieldWithBrowseButton();
    private final TextFieldWithBrowseButton sourceFileField = new TextFieldWithBrowseButton();
    private final JBTextField buildArgumentsField = new JBTextField();
    private final JBTextField programArgumentsField = new JBTextField();
    private final TextFieldWithBrowseButton gdbField = new TextFieldWithBrowseButton();
    private final EnvironmentVariablesComponent environmentVariablesComponent = new EnvironmentVariablesComponent();

    public SpiceDebugSettingsEditor() {
        compilerField.addBrowseFolderListener(null, FileChooserDescriptorFactory
                .createSingleFileNoJarsDescriptor()
                .withTitle("Select Spice Compiler"));

        FileChooserDescriptor sourceDescriptor = FileChooserDescriptorFactory
                .createSingleFileNoJarsDescriptor()
                .withTitle("Select Spice Source File")
                .withFileFilter(file -> "spice".equalsIgnoreCase(file.getExtension()));
        sourceFileField.addBrowseFolderListener(null, sourceDescriptor);

        gdbField.addBrowseFolderListener(null, FileChooserDescriptorFactory
                .createSingleFileNoJarsDescriptor()
                .withTitle("Select GDB Executable"));

        panel = FormBuilder.createFormBuilder()
                .addLabeledComponent("Spice compiler", compilerField)
                .addLabeledComponent("Main source file", sourceFileField)
                .addLabeledComponent("Build arguments", buildArgumentsField)
                .addLabeledComponent("Program arguments", programArgumentsField)
                .addLabeledComponent("GDB executable (optional)", gdbField)
                .addComponent(environmentVariablesComponent)
                .getPanel();
    }

    @Override
    protected void resetEditorFrom(@NotNull SpiceDebugRunConfiguration configuration) {
        compilerField.setText(configuration.getSpiceExecutablePath());
        sourceFileField.setText(configuration.getSourceFilePath());
        buildArgumentsField.setText(configuration.getBuildArguments());
        programArgumentsField.setText(configuration.getProgramArguments());
        gdbField.setText(configuration.getGdbExecutablePath());
        environmentVariablesComponent.setEnvData(configuration.getEnvironmentVariables());
    }

    @Override
    protected void applyEditorTo(@NotNull SpiceDebugRunConfiguration configuration) {
        configuration.setSpiceExecutablePath(compilerField.getText());
        configuration.setSourceFilePath(sourceFileField.getText());
        configuration.setBuildArguments(buildArgumentsField.getText());
        configuration.setProgramArguments(programArgumentsField.getText());
        configuration.setGdbExecutablePath(gdbField.getText());
        configuration.setEnvironmentVariables(environmentVariablesComponent.getEnvData());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return panel;
    }
}
