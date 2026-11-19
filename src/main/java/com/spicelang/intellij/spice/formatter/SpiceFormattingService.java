/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.formatter;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.CapturingProcessAdapter;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessEvent;
import com.intellij.formatting.service.AsyncDocumentFormattingService;
import com.intellij.formatting.service.AsyncFormattingRequest;
import com.intellij.formatting.service.FormattingService;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.spicelang.intellij.spice.psi.SpiceFile;
import com.spicelang.intellij.spice.settings.SpiceSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Set;

/**
 * Formats Spice files on "Reformat Code" with the formatter of the Spice compiler. 'spice format -' reads the source code from
 * stdin and prints the formatted code to stdout. The indentation on typing is still done by the built-in formatter.
 */
public class SpiceFormattingService extends AsyncDocumentFormattingService {

    public static final String NOTIFICATION_GROUP_ID = "Spice Formatter";
    private static final String TITLE = "Spice formatter";

    @NotNull
    @Override
    public Set<FormattingService.Feature> getFeatures() {
        // 'spice format' formats whole files only. Formatting a selection falls back to the built-in formatter
        return Collections.emptySet();
    }

    @Override
    public boolean canFormat(@NotNull PsiFile file) {
        return file instanceof SpiceFile && SpiceSettings.getInstance().isUseSpiceFormatter();
    }

    @Nullable
    @Override
    protected FormattingTask createFormattingTask(@NotNull AsyncFormattingRequest request) {
        String compiler = SpiceSettings.getInstance().getCompilerToRun();
        GeneralCommandLine commandLine = new GeneralCommandLine(compiler, "format", "-")
                .withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType.CONSOLE)
                .withCharset(StandardCharsets.UTF_8);
        VirtualFile virtualFile = request.getContext().getVirtualFile();
        if (virtualFile != null && virtualFile.getParent() != null && virtualFile.getParent().isInLocalFileSystem()) {
            commandLine.setWorkDirectory(virtualFile.getParent().getPath());
        }

        OSProcessHandler handler;
        try {
            handler = new OSProcessHandler(commandLine);
        } catch (ExecutionException e) {
            request.onError(TITLE, "Could not run the Spice compiler '" + compiler + "': " + e.getMessage()
                    + ". Install Spice or configure the compiler under Settings | Languages & Frameworks | Spice.");
            return null;
        }
        String sourceCode = request.getDocumentText();

        return new FormattingTask() {
            @Override
            public void run() {
                handler.addProcessListener(new CapturingProcessAdapter() {
                    @Override
                    public void processTerminated(@NotNull ProcessEvent event) {
                        if (event.getExitCode() == 0) {
                            request.onTextReady(getOutput().getStdout());
                        } else {
                            // The compiler prints its errors, e.g. syntax errors, to stdout
                            String message = (getOutput().getStderr() + getOutput().getStdout()).trim();
                            request.onError(TITLE, message.isEmpty()
                                    ? "'" + compiler + " format' exited with code " + event.getExitCode()
                                    : message);
                        }
                    }
                });
                handler.startNotify();

                // Pass the source code via stdin and close it, so that the formatter starts
                OutputStream stdin = handler.getProcessInput();
                if (stdin == null) {
                    handler.destroyProcess();
                    return;
                }
                try (stdin) {
                    stdin.write(sourceCode.getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    // The process terminated before reading the source code. Its output tells why
                }
            }

            @Override
            public boolean cancel() {
                handler.destroyProcess();
                return true;
            }

            @Override
            public boolean isRunUnderProgress() {
                return true;
            }
        };
    }

    @NotNull
    @Override
    protected String getNotificationGroupId() {
        return NOTIFICATION_GROUP_ID;
    }

    @NotNull
    @Override
    protected String getName() {
        return TITLE;
    }
}
