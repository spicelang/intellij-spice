/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.application.options.CodeStyle;
import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegate;
import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegateAdapter;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.spicelang.intellij.spice.psi.SpiceFile;
import org.jetbrains.annotations.NotNull;

/**
 * Indents the freshly created line(s) after Enter is pressed behind an opening curly brace,
 * relative to the actual indentation of the brace's line. This complements the formatter, which
 * otherwise anchors mid-line brace bodies (e.g. lambda bodies) to their canonical indent.
 */
public class SpiceEnterHandler extends EnterHandlerDelegateAdapter {

    @Override
    public Result postProcessEnter(@NotNull PsiFile file, @NotNull Editor editor, @NotNull DataContext dataContext) {
        if (!(file instanceof SpiceFile)) return Result.Continue;

        Document document = editor.getDocument();
        int caretOffset = editor.getCaretModel().getOffset();
        int caretLine = document.getLineNumber(caretOffset);
        if (caretLine == 0) return Result.Continue;

        // Only act when the previous line ends with an opening brace.
        String prevText = lineText(document, caretLine - 1);
        if (!prevText.stripTrailing().endsWith("{")) return Result.Continue;

        String baseIndent = leadingWhitespace(prevText);
        String newIndent = baseIndent + indentUnit(file);

        // Fix the closing-brace line first (it sits below the caret line, so its offsets stay valid
        // while we have not yet edited the caret line above it).
        int lastLine = document.getLineCount() - 1;
        if (caretLine + 1 <= lastLine) {
            String nextText = lineText(document, caretLine + 1);
            if (nextText.stripLeading().startsWith("}")) {
                replaceLeadingWhitespace(document, caretLine + 1, baseIndent);
            }
        }

        // Re-indent the caret line and place the caret at the end of the new indentation.
        int newCaretOffset = replaceLeadingWhitespace(document, caretLine, newIndent);
        editor.getCaretModel().moveToOffset(newCaretOffset);
        return Result.Stop;
    }

    private static String indentUnit(@NotNull PsiFile file) {
        CommonCodeStyleSettings.IndentOptions options = CodeStyle.getIndentOptions(file);
        if (options.USE_TAB_CHARACTER) return "\t";
        return " ".repeat(Math.max(1, options.INDENT_SIZE));
    }

    private static String lineText(@NotNull Document document, int line) {
        int start = document.getLineStartOffset(line);
        int end = document.getLineEndOffset(line);
        return document.getText(new TextRange(start, end));
    }

    private static String leadingWhitespace(@NotNull String text) {
        int i = 0;
        while (i < text.length() && (text.charAt(i) == ' ' || text.charAt(i) == '\t')) i++;
        return text.substring(0, i);
    }

    /** Replaces the leading whitespace of the given line with {@code indent}; returns the offset right after it. */
    private static int replaceLeadingWhitespace(@NotNull Document document, int line, @NotNull String indent) {
        int start = document.getLineStartOffset(line);
        int whitespaceLength = leadingWhitespace(lineText(document, line)).length();
        document.replaceString(start, start + whitespaceLength, indent);
        return start + indent.length();
    }
}
