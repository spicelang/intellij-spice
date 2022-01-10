package com.spicelang.intellij.spice;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.spicelang.intellij.spice.psi.SpiceTypes;
import jnr.a64asm.SIZE;
import org.jetbrains.annotations.NotNull;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SpiceSyntaxHighlighter extends SyntaxHighlighterBase {

    // Attribute keys
    private final TextAttributesKey TYPE_DOUBLE = createTextAttributesKey("SPICE_TYPE_DOUBLE", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey TYPE_INT = createTextAttributesKey("SPICE_TYPE_INT", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey TYPE_SHORT = createTextAttributesKey("SPICE_TYPE_SHORT", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey TYPE_LONG = createTextAttributesKey("SPICE_TYPE_LONG", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey TYPE_BYTE = createTextAttributesKey("SPICE_TYPE_BYTE", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey TYPE_CHAR = createTextAttributesKey("SPICE_TYPE_CHAR", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey TYPE_STRING = createTextAttributesKey("SPICE_TYPE_STRING", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey TYPE_BOOL = createTextAttributesKey("SPICE_TYPE_BOOL", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey TYPE_DYN = createTextAttributesKey("SPICE_TYPE_DYN", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey F = createTextAttributesKey("SPICE_F", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey P = createTextAttributesKey("SPICE_P", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey IF = createTextAttributesKey("SPICE_IF", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey ELSE = createTextAttributesKey("SPICE_ELSE", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey FOR = createTextAttributesKey("SPICE_FOR", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey FOREACH = createTextAttributesKey("SPICE_FOREACH", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey WHILE = createTextAttributesKey("SPICE_WHILE", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey CONST = createTextAttributesKey("SPICE_CONST", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey IMPORT = createTextAttributesKey("SPICE_IMPORT", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey BREAK = createTextAttributesKey("SPICE_BREAK", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey CONTINUE = createTextAttributesKey("SPICE_CONTINUE", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey RETURN = createTextAttributesKey("SPICE_RETURN", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey AS = createTextAttributesKey("SPICE_AS", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey STRUCT = createTextAttributesKey("SPICE_STRUCT", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey TYPE = createTextAttributesKey("SPICE_TYPE", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey NEW = createTextAttributesKey("SPICE_NEW", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey NIL = createTextAttributesKey("SPICE_NIL", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey MAIN = createTextAttributesKey("SPICE_MAIN", DefaultLanguageHighlighterColors.IDENTIFIER);
    private final TextAttributesKey PRINTF = createTextAttributesKey("SPICE_PRINTF", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey SIZEOF = createTextAttributesKey("SPICE_SIZEOF", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey EXT = createTextAttributesKey("SPICE_EXT", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey DLL = createTextAttributesKey("SPICE_DLL", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey TRUE = createTextAttributesKey("SPICE_TRUE", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey FALSE = createTextAttributesKey("SPICE_FALSE", DefaultLanguageHighlighterColors.KEYWORD);
    private final TextAttributesKey ELLIPSIS = createTextAttributesKey("SPICE_ELLIPSIS", DefaultLanguageHighlighterColors.INLAY_TEXT_WITHOUT_BACKGROUND);
    private final TextAttributesKey IDENTIFIER = createTextAttributesKey("SPICE_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    private final TextAttributesKey CHAR = createTextAttributesKey("SPICE_CHAR", DefaultLanguageHighlighterColors.STRING);
    private final TextAttributesKey STRING = createTextAttributesKey("SPICE_STRING", DefaultLanguageHighlighterColors.STRING);
    private final TextAttributesKey INTEGER = createTextAttributesKey("SPICE_INTEGER", DefaultLanguageHighlighterColors.NUMBER);
    private final TextAttributesKey DOUBLE = createTextAttributesKey("SPICE_DOUBLE", DefaultLanguageHighlighterColors.NUMBER);
    private final TextAttributesKey LBRACE = createTextAttributesKey("SPICE_LBRACE", DefaultLanguageHighlighterColors.BRACES);
    private final TextAttributesKey RBRACE = createTextAttributesKey("SPICE_RBRACE", DefaultLanguageHighlighterColors.BRACES);
    private final TextAttributesKey LPAREN = createTextAttributesKey("SPICE_LPAREN", DefaultLanguageHighlighterColors.PARENTHESES);
    private final TextAttributesKey RPAREN = createTextAttributesKey("SPICE_RPAREN", DefaultLanguageHighlighterColors.PARENTHESES);
    private final TextAttributesKey LBRACKET = createTextAttributesKey("SPICE_LBRACKET", DefaultLanguageHighlighterColors.BRACKETS);
    private final TextAttributesKey RBRACKET = createTextAttributesKey("SPICE_RBRACKET", DefaultLanguageHighlighterColors.BRACKETS);
    private final TextAttributesKey LOGICAL_OR = createTextAttributesKey("SPICE_LOGICAL_OR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey LOGICAL_AND = createTextAttributesKey("SPICE_LOGICAL_AND", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey BITWISE_OR = createTextAttributesKey("SPICE_BITWISE_OR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey BITWISE_AND = createTextAttributesKey("SPICE_BITWISE_AND", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey NOT = createTextAttributesKey("SPICE_NOT", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey PLUS_PLUS = createTextAttributesKey("SPICE_PLUS_PLUS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey MINUS_MINUS = createTextAttributesKey("SPICE_MINUS_MINUS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey PLUS_EQUAL = createTextAttributesKey("SPICE_PLUS_EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey MINUS_EQUAL = createTextAttributesKey("SPICE_MINUS_EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey MUL_EQUAL = createTextAttributesKey("SPICE_MUL_EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey DIV_EQUAL = createTextAttributesKey("SPICE_DIV_EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey SHL_EQUAL = createTextAttributesKey("SPICE_SHL_EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey SHR_EQUAL = createTextAttributesKey("SPICE_SHR_EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey SHL = createTextAttributesKey("SPICE_SHL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey SHR = createTextAttributesKey("SPICE_SHR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey PLUS = createTextAttributesKey("SPICE_PLUS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey MINUS = createTextAttributesKey("SPICE_MINUS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey MUL = createTextAttributesKey("SPICE_MUL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey DIV = createTextAttributesKey("SPICE_DIV", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey REM = createTextAttributesKey("SPICE_REM", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey LESS_EQUAL = createTextAttributesKey("SPICE_LESS_EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey GREATER_EQUAL = createTextAttributesKey("SPICE_GREATER_EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey LESS = createTextAttributesKey("SPICE_LESS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey GREATER = createTextAttributesKey("SPICE_GREATER", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey EQUAL = createTextAttributesKey("SPICE_EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey NOT_EQUAL = createTextAttributesKey("SPICE_NOT_EQUAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey ASSIGN_OP = createTextAttributesKey("SPICE_ASSIGN_OP", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey QUESTION_MARK = createTextAttributesKey("SPICE_QUESTION_MARK", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey SEMICOLON = createTextAttributesKey("SPICE_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    private final TextAttributesKey COLON = createTextAttributesKey("SPICE_COLON", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private final TextAttributesKey COMMA = createTextAttributesKey("SPICE_COMMA", DefaultLanguageHighlighterColors.COMMA);
    private final TextAttributesKey DOT = createTextAttributesKey("SPICE_DOT", DefaultLanguageHighlighterColors.DOT);
    private final TextAttributesKey LINE_COMMENT = createTextAttributesKey("SPICE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    private final TextAttributesKey BLOCK_COMMENT = createTextAttributesKey("SPICE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    private final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SPICE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    // Attribute key arrays
    private final TextAttributesKey[] TYPE_DOUBLE_KEYS = new TextAttributesKey[] { TYPE_DOUBLE };
    private final TextAttributesKey[] TYPE_INT_KEYS = new TextAttributesKey[] { TYPE_INT };
    private final TextAttributesKey[] TYPE_SHORT_KEYS = new TextAttributesKey[] { TYPE_SHORT };
    private final TextAttributesKey[] TYPE_LONG_KEYS = new TextAttributesKey[] { TYPE_LONG };
    private final TextAttributesKey[] TYPE_BYTE_KEYS = new TextAttributesKey[] { TYPE_BYTE };
    private final TextAttributesKey[] TYPE_CHAR_KEYS = new TextAttributesKey[] { TYPE_CHAR };
    private final TextAttributesKey[] TYPE_STRING_KEYS = new TextAttributesKey[] { TYPE_STRING };
    private final TextAttributesKey[] TYPE_BOOL_KEYS = new TextAttributesKey[] { TYPE_BOOL };
    private final TextAttributesKey[] TYPE_DYN_KEYS = new TextAttributesKey[] { TYPE_DYN };
    private final TextAttributesKey[] F_KEYS = new TextAttributesKey[] { F };
    private final TextAttributesKey[] P_KEYS = new TextAttributesKey[] { P };
    private final TextAttributesKey[] IF_KEYS = new TextAttributesKey[] { IF };
    private final TextAttributesKey[] ELSE_KEYS = new TextAttributesKey[] { ELSE };
    private final TextAttributesKey[] FOR_KEYS = new TextAttributesKey[] { FOR };
    private final TextAttributesKey[] FOREACH_KEYS = new TextAttributesKey[] { FOREACH };
    private final TextAttributesKey[] WHILE_KEYS = new TextAttributesKey[] { WHILE };
    private final TextAttributesKey[] CONST_KEYS = new TextAttributesKey[] { CONST };
    private final TextAttributesKey[] IMPORT_KEYS = new TextAttributesKey[] { IMPORT };
    private final TextAttributesKey[] BREAK_KEYS = new TextAttributesKey[] { BREAK };
    private final TextAttributesKey[] CONTINUE_KEYS = new TextAttributesKey[] { CONTINUE };
    private final TextAttributesKey[] RETURN_KEYS = new TextAttributesKey[] { RETURN };
    private final TextAttributesKey[] AS_KEYS = new TextAttributesKey[] { AS };
    private final TextAttributesKey[] STRUCT_KEYS = new TextAttributesKey[] { STRUCT };
    private final TextAttributesKey[] TYPE_KEYS = new TextAttributesKey[] { TYPE };
    private final TextAttributesKey[] NEW_KEYS = new TextAttributesKey[] { NEW };
    private final TextAttributesKey[] NIL_KEYS = new TextAttributesKey[] { NIL };
    private final TextAttributesKey[] MAIN_KEYS = new TextAttributesKey[] { MAIN };
    private final TextAttributesKey[] PRINTF_KEYS = new TextAttributesKey[] { PRINTF };
    private final TextAttributesKey[] SIZEOF_KEYS = new TextAttributesKey[] { SIZEOF };
    private final TextAttributesKey[] EXT_KEYS = new TextAttributesKey[] { EXT };
    private final TextAttributesKey[] DLL_KEYS = new TextAttributesKey[] { DLL };
    private final TextAttributesKey[] TRUE_KEYS = new TextAttributesKey[] { TRUE };
    private final TextAttributesKey[] FALSE_KEYS = new TextAttributesKey[] { FALSE };
    private final TextAttributesKey[] ELLIPSIS_KEYS = new TextAttributesKey[] { ELLIPSIS };
    private final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[] { IDENTIFIER };
    private final TextAttributesKey[] CHAR_KEYS = new TextAttributesKey[] { CHAR };
    private final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[] { STRING };
    private final TextAttributesKey[] INTEGER_KEYS = new TextAttributesKey[] { INTEGER };
    private final TextAttributesKey[] DOUBLE_KEYS = new TextAttributesKey[] { DOUBLE };
    private final TextAttributesKey[] LBRACE_KEYS = new TextAttributesKey[] { LBRACE };
    private final TextAttributesKey[] RBRACE_KEYS = new TextAttributesKey[] { RBRACE };
    private final TextAttributesKey[] LPAREN_KEYS = new TextAttributesKey[] { LPAREN };
    private final TextAttributesKey[] RPAREN_KEYS = new TextAttributesKey[] { RPAREN };
    private final TextAttributesKey[] LBRACKET_KEYS = new TextAttributesKey[] { LBRACKET };
    private final TextAttributesKey[] RBRACKET_KEYS = new TextAttributesKey[] { RBRACKET };
    private final TextAttributesKey[] LOGICAL_OR_KEYS = new TextAttributesKey[] { LOGICAL_OR };
    private final TextAttributesKey[] LOGICAL_AND_KEYS = new TextAttributesKey[] { LOGICAL_AND };
    private final TextAttributesKey[] BITWISE_OR_KEYS = new TextAttributesKey[] { BITWISE_OR };
    private final TextAttributesKey[] BITWISE_AND_KEYS = new TextAttributesKey[] { BITWISE_AND };
    private final TextAttributesKey[] NOT_KEYS = new TextAttributesKey[] { NOT };
    private final TextAttributesKey[] PLUS_PLUS_KEYS = new TextAttributesKey[] { PLUS_PLUS };
    private final TextAttributesKey[] MINUS_MINUS_KEYS = new TextAttributesKey[] { MINUS_MINUS };
    private final TextAttributesKey[] PLUS_EQUAL_KEYS = new TextAttributesKey[] { PLUS_EQUAL };
    private final TextAttributesKey[] MINUS_EQUAL_KEYS = new TextAttributesKey[] { MINUS_EQUAL };
    private final TextAttributesKey[] MUL_EQUAL_KEYS = new TextAttributesKey[] { MUL_EQUAL };
    private final TextAttributesKey[] DIV_EQUAL_KEYS = new TextAttributesKey[] { DIV_EQUAL };
    private final TextAttributesKey[] SHL_EQUAL_KEYS = new TextAttributesKey[] { SHL_EQUAL };
    private final TextAttributesKey[] SHR_EQUAL_KEYS = new TextAttributesKey[] { SHR_EQUAL };
    private final TextAttributesKey[] SHL_KEYS = new TextAttributesKey[] { SHL };
    private final TextAttributesKey[] SHR_KEYS = new TextAttributesKey[] { SHR };
    private final TextAttributesKey[] PLUS_KEYS = new TextAttributesKey[] { PLUS };
    private final TextAttributesKey[] MINUS_KEYS = new TextAttributesKey[] { MINUS };
    private final TextAttributesKey[] MUL_KEYS = new TextAttributesKey[] { MUL };
    private final TextAttributesKey[] DIV_KEYS = new TextAttributesKey[] { DIV };
    private final TextAttributesKey[] REM_KEYS = new TextAttributesKey[] { REM };
    private final TextAttributesKey[] LESS_EQUAL_KEYS = new TextAttributesKey[] { LESS_EQUAL };
    private final TextAttributesKey[] GREATER_EQUAL_KEYS = new TextAttributesKey[] { GREATER_EQUAL };
    private final TextAttributesKey[] LESS_KEYS = new TextAttributesKey[] { LESS };
    private final TextAttributesKey[] GREATER_KEYS = new TextAttributesKey[] { GREATER };
    private final TextAttributesKey[] EQUAL_KEYS = new TextAttributesKey[] { EQUAL };
    private final TextAttributesKey[] NOT_EQUAL_KEYS = new TextAttributesKey[] { NOT_EQUAL };
    private final TextAttributesKey[] ASSIGN_OP_KEYS = new TextAttributesKey[] { ASSIGN_OP };
    private final TextAttributesKey[] QUESTION_MARK_KEYS = new TextAttributesKey[] { QUESTION_MARK };
    private final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[] { SEMICOLON };
    private final TextAttributesKey[] COLON_KEYS = new TextAttributesKey[] { COLON };
    private final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[] { COMMA };
    private final TextAttributesKey[] DOT_KEYS = new TextAttributesKey[] { DOT };
    private final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[] { LINE_COMMENT };
    private final TextAttributesKey[] BLOCK_COMMENT_KEYS = new TextAttributesKey[] { BLOCK_COMMENT };
    private final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[] { BAD_CHARACTER };
    private final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SpiceLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(SpiceTypes.TYPE_DOUBLE)) return TYPE_DOUBLE_KEYS;
        if (tokenType.equals(SpiceTypes.TYPE_INT)) return TYPE_INT_KEYS;
        if (tokenType.equals(SpiceTypes.TYPE_SHORT)) return TYPE_SHORT_KEYS;
        if (tokenType.equals(SpiceTypes.TYPE_LONG)) return TYPE_LONG_KEYS;
        if (tokenType.equals(SpiceTypes.TYPE_BYTE)) return TYPE_BYTE_KEYS;
        if (tokenType.equals(SpiceTypes.TYPE_CHAR)) return TYPE_CHAR_KEYS;
        if (tokenType.equals(SpiceTypes.TYPE_STRING)) return TYPE_STRING_KEYS;
        if (tokenType.equals(SpiceTypes.TYPE_BOOL)) return TYPE_BOOL_KEYS;
        if (tokenType.equals(SpiceTypes.TYPE_DYN)) return TYPE_DYN_KEYS;
        if (tokenType.equals(SpiceTypes.F)) return F_KEYS;
        if (tokenType.equals(SpiceTypes.P)) return P_KEYS;
        if (tokenType.equals(SpiceTypes.IF)) return IF_KEYS;
        if (tokenType.equals(SpiceTypes.ELSE)) return ELSE_KEYS;
        if (tokenType.equals(SpiceTypes.FOR)) return FOR_KEYS;
        if (tokenType.equals(SpiceTypes.FOREACH)) return FOREACH_KEYS;
        if (tokenType.equals(SpiceTypes.WHILE)) return WHILE_KEYS;
        if (tokenType.equals(SpiceTypes.CONST)) return CONST_KEYS;
        if (tokenType.equals(SpiceTypes.IMPORT)) return IMPORT_KEYS;
        if (tokenType.equals(SpiceTypes.BREAK)) return BREAK_KEYS;
        if (tokenType.equals(SpiceTypes.CONTINUE)) return CONTINUE_KEYS;
        if (tokenType.equals(SpiceTypes.RETURN)) return RETURN_KEYS;
        if (tokenType.equals(SpiceTypes.AS)) return AS_KEYS;
        if (tokenType.equals(SpiceTypes.STRUCT)) return STRUCT_KEYS;
        if (tokenType.equals(SpiceTypes.TYPE)) return TYPE_KEYS;
        if (tokenType.equals(SpiceTypes.NEW)) return NEW_KEYS;
        if (tokenType.equals(SpiceTypes.NIL)) return NIL_KEYS;
        if (tokenType.equals(SpiceTypes.MAIN)) return MAIN_KEYS;
        if (tokenType.equals(SpiceTypes.PRINTF)) return PRINTF_KEYS;
        if (tokenType.equals(SpiceTypes.SIZEOF)) return SIZEOF_KEYS;
        if (tokenType.equals(SpiceTypes.EXT)) return EXT_KEYS;
        if (tokenType.equals(SpiceTypes.DLL)) return DLL_KEYS;
        if (tokenType.equals(SpiceTypes.TRUE)) return TRUE_KEYS;
        if (tokenType.equals(SpiceTypes.FALSE)) return FALSE_KEYS;
        if (tokenType.equals(SpiceTypes.ELLIPSIS)) return ELLIPSIS_KEYS;
        if (tokenType.equals(SpiceTypes.IDENTIFIER)) return IDENTIFIER_KEYS;
        if (tokenType.equals(SpiceTypes.CHAR)) return CHAR_KEYS;
        if (tokenType.equals(SpiceTypes.STRING)) return STRING_KEYS;
        if (tokenType.equals(SpiceTypes.INTEGER)) return INTEGER_KEYS;
        if (tokenType.equals(SpiceTypes.DOUBLE)) return DOUBLE_KEYS;
        if (tokenType.equals(SpiceTypes.LBRACE)) return LBRACE_KEYS;
        if (tokenType.equals(SpiceTypes.RBRACE)) return RBRACE_KEYS;
        if (tokenType.equals(SpiceTypes.LPAREN)) return LPAREN_KEYS;
        if (tokenType.equals(SpiceTypes.RPAREN)) return RPAREN_KEYS;
        if (tokenType.equals(SpiceTypes.LBRACKET)) return LBRACKET_KEYS;
        if (tokenType.equals(SpiceTypes.RBRACKET)) return RBRACKET_KEYS;
        if (tokenType.equals(SpiceTypes.LOGICAL_OR)) return LOGICAL_OR_KEYS;
        if (tokenType.equals(SpiceTypes.LOGICAL_AND)) return LOGICAL_AND_KEYS;
        if (tokenType.equals(SpiceTypes.BITWISE_OR)) return BITWISE_OR_KEYS;
        if (tokenType.equals(SpiceTypes.BITWISE_AND)) return BITWISE_AND_KEYS;
        if (tokenType.equals(SpiceTypes.NOT)) return NOT_KEYS;
        if (tokenType.equals(SpiceTypes.PLUS_PLUS)) return PLUS_PLUS_KEYS;
        if (tokenType.equals(SpiceTypes.MINUS_MINUS)) return MINUS_MINUS_KEYS;
        if (tokenType.equals(SpiceTypes.PLUS_EQUAL)) return PLUS_EQUAL_KEYS;
        if (tokenType.equals(SpiceTypes.MINUS_EQUAL)) return MINUS_EQUAL_KEYS;
        if (tokenType.equals(SpiceTypes.MUL_EQUAL)) return MUL_EQUAL_KEYS;
        if (tokenType.equals(SpiceTypes.DIV_EQUAL)) return DIV_EQUAL_KEYS;
        if (tokenType.equals(SpiceTypes.SHL_EQUAL)) return SHL_EQUAL_KEYS;
        if (tokenType.equals(SpiceTypes.SHR_EQUAL)) return SHR_EQUAL_KEYS;
        if (tokenType.equals(SpiceTypes.SHL)) return SHL_KEYS;
        if (tokenType.equals(SpiceTypes.SHR)) return SHR_KEYS;
        if (tokenType.equals(SpiceTypes.PLUS)) return PLUS_KEYS;
        if (tokenType.equals(SpiceTypes.MINUS)) return MINUS_KEYS;
        if (tokenType.equals(SpiceTypes.MUL)) return MUL_KEYS;
        if (tokenType.equals(SpiceTypes.DIV)) return DIV_KEYS;
        if (tokenType.equals(SpiceTypes.REM)) return REM_KEYS;
        if (tokenType.equals(SpiceTypes.LESS_EQUAL)) return LESS_EQUAL_KEYS;
        if (tokenType.equals(SpiceTypes.GREATER_EQUAL)) return GREATER_EQUAL_KEYS;
        if (tokenType.equals(SpiceTypes.LESS)) return LESS_KEYS;
        if (tokenType.equals(SpiceTypes.GREATER)) return GREATER_KEYS;
        if (tokenType.equals(SpiceTypes.EQUAL)) return EQUAL_KEYS;
        if (tokenType.equals(SpiceTypes.NOT_EQUAL)) return NOT_EQUAL_KEYS;
        if (tokenType.equals(SpiceTypes.ASSIGN_OP)) return ASSIGN_OP_KEYS;
        if (tokenType.equals(SpiceTypes.QUESTION_MARK)) return QUESTION_MARK_KEYS;
        if (tokenType.equals(SpiceTypes.SEMICOLON)) return SEMICOLON_KEYS;
        if (tokenType.equals(SpiceTypes.COLON)) return COLON_KEYS;
        if (tokenType.equals(SpiceTypes.COMMA)) return COMMA_KEYS;
        if (tokenType.equals(SpiceTypes.DOT)) return DOT_KEYS;
        if (tokenType.equals(SpiceTypes.LINE_COMMENT)) return LINE_COMMENT_KEYS;
        if (tokenType.equals(SpiceTypes.BLOCK_COMMENT)) return BLOCK_COMMENT_KEYS;
        if (tokenType.equals(TokenType.BAD_CHARACTER)) return BAD_CHAR_KEYS;
        return EMPTY_KEYS;
    }
}