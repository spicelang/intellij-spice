/*
 * Copyright (c) 2022-2023 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.spicelang.intellij.spice.psi.SpiceTypes;
import org.jetbrains.annotations.NotNull;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SpiceSyntaxHighlighter extends SyntaxHighlighterBase {

    // Attribute keys
    protected static final TextAttributesKey TYPE = createTextAttributesKey("SPICE_TYPE", DefaultLanguageHighlighterColors.KEYWORD);
    protected static final TextAttributesKey TYPE_MODIFIER = createTextAttributesKey("SPICE_TYPE_MODIFIER", DefaultLanguageHighlighterColors.KEYWORD);
    protected static final TextAttributesKey KEYWORD = createTextAttributesKey("SPICE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    protected static final TextAttributesKey IDENTIFIER = createTextAttributesKey("SPICE_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    protected static final TextAttributesKey BUILTIN = createTextAttributesKey("SPICE_BUILTIN", DefaultLanguageHighlighterColors.KEYWORD);
    protected static final TextAttributesKey CONSTANT = createTextAttributesKey("SPICE_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    protected static final TextAttributesKey OPERATOR = createTextAttributesKey("SPICE_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    protected static final TextAttributesKey SECONDARY_OPERATOR = createTextAttributesKey("SPICE_SECONDARY_OPERATOR", DefaultLanguageHighlighterColors.INLAY_TEXT_WITHOUT_BACKGROUND);
    protected static final TextAttributesKey BRACES = createTextAttributesKey("SPICE_BRACES", DefaultLanguageHighlighterColors.BRACES);
    protected static final TextAttributesKey PARENTHESES = createTextAttributesKey("SPICE_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    protected static final TextAttributesKey BRACKETS = createTextAttributesKey("SPICE_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    protected static final TextAttributesKey COMMA = createTextAttributesKey("SPICE_COMMA", DefaultLanguageHighlighterColors.COMMA);
    protected static final TextAttributesKey DOT = createTextAttributesKey("SPICE_DOT", DefaultLanguageHighlighterColors.DOT);
    protected static final TextAttributesKey LINE_COMMENT = createTextAttributesKey("SPICE_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    protected static final TextAttributesKey BLOCK_COMMENT = createTextAttributesKey("SPICE_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    protected static final TextAttributesKey DOC_COMMENT = createTextAttributesKey("SPICE_DOC_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT);
    protected static final TextAttributesKey NUMBER = createTextAttributesKey("SPICE_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    protected static final TextAttributesKey STRING = createTextAttributesKey("SPICE_STRING", DefaultLanguageHighlighterColors.STRING);
    protected static final TextAttributesKey ATTR = createTextAttributesKey("SPICE_ATTR", DefaultLanguageHighlighterColors.METADATA);
    protected static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SPICE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    // Attribute key arrays
    private final TextAttributesKey[] TYPE_KEY = new TextAttributesKey[] { TYPE };
    private final TextAttributesKey[] TYPE_MODIFIER_KEY = new TextAttributesKey[] { TYPE_MODIFIER };
    private final TextAttributesKey[] KEYWORD_KEY = new TextAttributesKey[] { KEYWORD};
    private final TextAttributesKey[] IDENTIFIER_KEY = new TextAttributesKey[] { IDENTIFIER };
    private final TextAttributesKey[] BUILTIN_KEY = new TextAttributesKey[] { BUILTIN };
    private final TextAttributesKey[] CONSTANT_KEY = new TextAttributesKey[] { CONSTANT };
    private final TextAttributesKey[] OPERATOR_KEY = new TextAttributesKey[] { OPERATOR };
    private final TextAttributesKey[] SECONDARY_OPERATOR_KEY = new TextAttributesKey[] { SECONDARY_OPERATOR };
    private final TextAttributesKey[] BRACES_KEY = new TextAttributesKey[] { BRACES };
    private final TextAttributesKey[] PARENTHESES_KEY = new TextAttributesKey[] { PARENTHESES };
    private final TextAttributesKey[] BRACKETS_KEY = new TextAttributesKey[] { BRACKETS };
    private final TextAttributesKey[] COMMA_KEY = new TextAttributesKey[] { COMMA };
    private final TextAttributesKey[] DOT_KEY = new TextAttributesKey[] { DOT };
    private final TextAttributesKey[] LINE_COMMENT_KEY = new TextAttributesKey[] { LINE_COMMENT };
    private final TextAttributesKey[] BLOCK_COMMENT_KEY = new TextAttributesKey[] { BLOCK_COMMENT };
    private final TextAttributesKey[] DOC_COMMENT_KEY = new TextAttributesKey[] { DOC_COMMENT };
    private final TextAttributesKey[] NUMBER_KEY = new TextAttributesKey[] { NUMBER };
    private final TextAttributesKey[] STRING_KEY = new TextAttributesKey[] { STRING };
    private final TextAttributesKey[] ATTR_KEY = new TextAttributesKey[] { ATTR };
    private final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[] { BAD_CHARACTER };
    private final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SpiceLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(SpiceTypes.TYPE_DOUBLE)) return TYPE_KEY;
        if (tokenType.equals(SpiceTypes.TYPE_INT)) return TYPE_KEY;
        if (tokenType.equals(SpiceTypes.TYPE_SHORT)) return TYPE_KEY;
        if (tokenType.equals(SpiceTypes.TYPE_LONG)) return TYPE_KEY;
        if (tokenType.equals(SpiceTypes.TYPE_BYTE)) return TYPE_KEY;
        if (tokenType.equals(SpiceTypes.TYPE_CHAR)) return TYPE_KEY;
        if (tokenType.equals(SpiceTypes.TYPE_STRING)) return TYPE_KEY;
        if (tokenType.equals(SpiceTypes.TYPE_BOOL)) return TYPE_KEY;
        if (tokenType.equals(SpiceTypes.TYPE_DYN)) return TYPE_KEY;
        if (tokenType.equals(SpiceTypes.SIGNED)) return TYPE_MODIFIER_KEY;
        if (tokenType.equals(SpiceTypes.UNSIGNED)) return TYPE_MODIFIER_KEY;
        if (tokenType.equals(SpiceTypes.INLINE)) return TYPE_MODIFIER_KEY;
        if (tokenType.equals(SpiceTypes.PUBLIC)) return TYPE_MODIFIER_KEY;
        if (tokenType.equals(SpiceTypes.CONST)) return TYPE_MODIFIER_KEY;
        if (tokenType.equals(SpiceTypes.HEAP)) return TYPE_MODIFIER_KEY;
        if (tokenType.equals(SpiceTypes.COMPOSE)) return TYPE_MODIFIER_KEY;
        if (tokenType.equals(SpiceTypes.F)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.P)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.IF)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.ELSE)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.SWITCH)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.CASE)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.DEFAULT)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.ASSERT)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.FOR)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.FOREACH)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.DO)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.WHILE)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.IMPORT)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.BREAK)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.CONTINUE)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.FALLTHROUGH)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.RETURN)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.AS)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.STRUCT)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.INTERFACE)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.TYPE)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.ENUM)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.OPERATOR)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.ALIAS)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.UNSAFE)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.NIL)) return CONSTANT_KEY;
        if (tokenType.equals(SpiceTypes.MAIN)) return IDENTIFIER_KEY;
        if (tokenType.equals(SpiceTypes.PRINTF)) return BUILTIN_KEY;
        if (tokenType.equals(SpiceTypes.SIZEOF)) return BUILTIN_KEY;
        if (tokenType.equals(SpiceTypes.ALIGNOF)) return BUILTIN_KEY;
        if (tokenType.equals(SpiceTypes.LEN)) return BUILTIN_KEY;
        if (tokenType.equals(SpiceTypes.PANIC)) return BUILTIN_KEY;
        if (tokenType.equals(SpiceTypes.SYSCALL)) return BUILTIN_KEY;
        if (tokenType.equals(SpiceTypes.CAST)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.EXT)) return KEYWORD_KEY;
        if (tokenType.equals(SpiceTypes.TRUE)) return CONSTANT_KEY;
        if (tokenType.equals(SpiceTypes.FALSE)) return CONSTANT_KEY;
        if (tokenType.equals(SpiceTypes.IDENTIFIER)) return IDENTIFIER_KEY;
        if (tokenType.equals(SpiceTypes.CHAR_LIT)) return STRING_KEY;
        if (tokenType.equals(SpiceTypes.STRING_LIT)) return STRING_KEY;
        if (tokenType.equals(SpiceTypes.INT_LIT)) return NUMBER_KEY;
        if (tokenType.equals(SpiceTypes.SHORT_LIT)) return NUMBER_KEY;
        if (tokenType.equals(SpiceTypes.LONG_LIT)) return NUMBER_KEY;
        if (tokenType.equals(SpiceTypes.DOUBLE_LIT)) return NUMBER_KEY;
        if (tokenType.equals(SpiceTypes.LBRACE)) return BRACES_KEY;
        if (tokenType.equals(SpiceTypes.RBRACE)) return BRACES_KEY;
        if (tokenType.equals(SpiceTypes.LPAREN)) return PARENTHESES_KEY;
        if (tokenType.equals(SpiceTypes.RPAREN)) return PARENTHESES_KEY;
        if (tokenType.equals(SpiceTypes.LBRACKET)) return BRACKETS_KEY;
        if (tokenType.equals(SpiceTypes.RBRACKET)) return BRACKETS_KEY;
        if (tokenType.equals(SpiceTypes.LOGICAL_OR)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.LOGICAL_AND)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.BITWISE_OR)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.BITWISE_XOR)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.BITWISE_AND)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.PLUS_PLUS)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.MINUS_MINUS)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.PLUS_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.MINUS_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.MUL_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.DIV_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.REM_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.SHL_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.SHR_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.AND_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.OR_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.XOR_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.PLUS)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.MINUS)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.MUL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.DIV)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.REM)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.NOT)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.BITWISE_NOT)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.GREATER)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.LESS)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.GREATER_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.LESS_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.NOT_EQUAL)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.ASSIGN_OP)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.QUESTION_MARK)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.SEMICOLON)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.COLON)) return OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.COMMA)) return COMMA_KEY;
        if (tokenType.equals(SpiceTypes.DOT)) return DOT_KEY;
        if (tokenType.equals(SpiceTypes.ELLIPSIS)) return SECONDARY_OPERATOR_KEY;
        if (tokenType.equals(SpiceTypes.TOPLEVEL_ATTR_PREAMBLE)) return ATTR_KEY;
        if (tokenType.equals(SpiceTypes.MOD_ATTR_PREAMBLE)) return ATTR_KEY;
        if (tokenType.equals(SpiceTypes.LINE_COMMENT)) return LINE_COMMENT_KEY;
        if (tokenType.equals(SpiceTypes.BLOCK_COMMENT)) return BLOCK_COMMENT_KEY;
        if (tokenType.equals(SpiceTypes.DOC_COMMENT)) return DOC_COMMENT_KEY;
        if (tokenType.equals(TokenType.BAD_CHARACTER)) return BAD_CHAR_KEYS;
        return EMPTY_KEYS;
    }
}