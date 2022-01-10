package com.spicelang.intellij.spice;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class SpiceColorSettingsPage implements ColorSettingsPage {
    private final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Data types", SpiceSyntaxHighlighter.TYPE),
            new AttributesDescriptor("Keywords", SpiceSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Identifiers", SpiceSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("Builtin functions", SpiceSyntaxHighlighter.BUILTIN),
            new AttributesDescriptor("Constants", SpiceSyntaxHighlighter.CONSTANT),
            new AttributesDescriptor("Operators", SpiceSyntaxHighlighter.OPERATOR),
            new AttributesDescriptor("Secondary operators", SpiceSyntaxHighlighter.SECONDARY_OPERATOR),
            new AttributesDescriptor("Braces", SpiceSyntaxHighlighter.BRACES),
            new AttributesDescriptor("Parentheses", SpiceSyntaxHighlighter.PARENTHESES),
            new AttributesDescriptor("Brackets", SpiceSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Commas", SpiceSyntaxHighlighter.COMMA),
            new AttributesDescriptor("Dots", SpiceSyntaxHighlighter.DOT),
            new AttributesDescriptor("Line comments", SpiceSyntaxHighlighter.LINE_COMMENT),
            new AttributesDescriptor("Block comments", SpiceSyntaxHighlighter.BLOCK_COMMENT),
            new AttributesDescriptor("Numbers", SpiceSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("String/char literals", SpiceSyntaxHighlighter.STRING),
            new AttributesDescriptor("Bad value", SpiceSyntaxHighlighter.BAD_CHARACTER)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return SpiceIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new SpiceSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "f<int> main() {\n" +
                "    printf(\"Hello World!\");\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Spice";
    }
}
