package com.spicelang.intellij.spice;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.spicelang.intellij.spice.psi.SpiceTokenType;
import com.spicelang.intellij.spice.psi.SpiceTypes;
import com.intellij.psi.TokenType;

%%

%class SpiceLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

%eof{
    return;
%eof}

// Macro definitions
TYPE_DOUBLE = "double"
TYPE_INT = "int"
TYPE_SHORT = "short"
TYPE_LONG = "long"
TYPE_BYTE = "byte"
TYPE_CHAR = "char"
TYPE_STRING = "string"
TYPE_BOOL = "bool"
TYPE_DYN = "dyn"
F = "f"
P = "p"
IF = "if"
ELSE = "else"
FOR = "for"
FOREACH = "foreach"
WHILE = "while"
CONST = "const"
IMPORT = "import"
BREAK = "break"
CONTINUE = "continue"
RETURN = "return"
AS = "as"
STRUCT = "struct"
TYPE = "type"
NEW = "new"
NIL = "nil"
MAIN = "main"
PRINTF = "printf"
SIZEOF = "sizeof"
EXT = "ext"
DLL = "dll"
ELLIPSIS = "..."
TRUE = "true"
FALSE = "false"
CHAR = "'" (~['\\\r\n] | "\\" (. | EOF)) "'"
STRING = "\"" (~[\"\\\r\n] | "\\" (. | EOF))* "\""
INTEGER = "-"? [1-9]+[0-9]* | "0"
DOUBLE = "-"? [0-9]+.[0-9]+
IDENTIFIER = [_a-zA-Z][_a-zA-Z0-9]*
LBRACE = "{"
RBRACE = "}"
LPAREN = "("
RPAREN = ")"
LBRACKET = "["
RBRACKET = "]"
LOGICAL_OR = "||"
LOGICAL_AND = "&&"
BITWISE_OR = "|"
BITWISE_AND = "&"
NOT = "!"
PLUS_PLUS = "++"
MINUS_MINUS = "--"
PLUS_EQUAL = "+="
MINUS_EQUAL = "-="
MUL_EQUAL = "*="
DIV_EQUAL = "/="
SHL_EQUAL = "<<="
SHR_EQUAL = ">>="
SHL = "<<"
SHR = ">>"
PLUS = "+"
MINUS = "-"
MUL = "*"
DIV = "/"
REM = "%"
GREATER = ">"
LESS = "<"
GREATER_EQUAL = ">="
LESS_EQUAL = "<="
EQUAL = "=="
NOT_EQUAL = "!="
ASSIGN_OP = "="
QUESTION_MARK = "?"
SEMICOLON = ";"
COLON = ":"
COMMA = ","
DOT = "."
BLOCK_COMMENT = "/*" .*? "*/"
LINE_COMMENT = "//" ~[\r\n]*
WS = [ \t\r\n]+

%%

{TYPE_DOUBLE}                                       { return SpiceTypes.TYPE_DOUBLE; }
{TYPE_INT}                                          { return SpiceTypes.TYPE_INT; }

[^]                                                 { return TokenType.BAD_CHARACTER; }