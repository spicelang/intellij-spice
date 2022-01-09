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
{TYPE_SHORT}                                        { return SpiceTypes.TYPE_SHORT; }
{TYPE_LONG}                                         { return SpiceTypes.TYPE_LONG; }
{TYPE_BYTE}                                         { return SpiceTypes.TYPE_BYTE; }
{TYPE_CHAR}                                         { return SpiceTypes.TYPE_CHAR; }
{TYPE_STRING}                                       { return SpiceTypes.TYPE_STRING; }
{TYPE_BOOL}                                         { return SpiceTypes.TYPE_BOOL; }
{TYPE_DYN}                                          { return SpiceTypes.TYPE_DYN; }
{F}                                                 { return SpiceTypes.F; }
{P}                                                 { return SpiceTypes.P; }
{IF}                                                { return SpiceTypes.IF; }
{ELSE}                                              { return SpiceTypes.ELSE; }
{FOR}                                               { return SpiceTypes.FOR; }
{FOREACH}                                           { return SpiceTypes.FOREACH; }
{WHILE}                                             { return SpiceTypes.WHILE; }
{CONST}                                             { return SpiceTypes.CONST; }
{IMPORT}                                            { return SpiceTypes.IMPORT; }
{BREAK}                                             { return SpiceTypes.BREAK; }
{CONTINUE}                                          { return SpiceTypes.CONTINUE; }
{RETURN}                                            { return SpiceTypes.RETURN; }
{AS}                                                { return SpiceTypes.AS; }
{STRUCT}                                            { return SpiceTypes.STRUCT; }
{TYPE}                                              { return SpiceTypes.TYPE; }
{NEW}                                               { return SpiceTypes.NEW; }
{NIL}                                               { return SpiceTypes.NIL; }
{MAIN}                                              { return SpiceTypes.MAIN; }
{PRINTF}                                            { return SpiceTypes.PRINTF; }
{SIZEOF}                                            { return SpiceTypes.SIZEOF; }
{EXT}                                               { return SpiceTypes.EXT; }
{DLL}                                               { return SpiceTypes.DLL; }
{ELLIPSIS}                                          { return SpiceTypes.ELLIPSIS; }
{TRUE}                                              { return SpiceTypes.TRUE; }
{FALSE}                                             { return SpiceTypes.FALSE; }
{CHAR}                                              { return SpiceTypes.CHAR; }
{STRING}                                            { return SpiceTypes.STRING; }
{INTEGER}                                           { return SpiceTypes.INTEGER; }
{DOUBLE}                                            { return SpiceTypes.DOUBLE; }
{IDENTIFIER}                                        { return SpiceTypes.IDENTIFIER; }
{LBRACE}                                            { return SpiceTypes.LBRACE; }
{RBRACE}                                            { return SpiceTypes.RBRACE; }
{LPAREN}                                            { return SpiceTypes.LPAREN; }
{RPAREN}                                            { return SpiceTypes.RPAREN; }
{LBRACKET}                                          { return SpiceTypes.LBRACKET; }
{RBRACKET}                                          { return SpiceTypes.RBRACKET; }
{LOGICAL_OR}                                        { return SpiceTypes.LOGICAL_OR; }
{LOGICAL_AND}                                       { return SpiceTypes.LOGICAL_AND; }
{BITWISE_OR}                                        { return SpiceTypes.BITWISE_OR; }
{BITWISE_AND}                                       { return SpiceTypes.BITWISE_AND; }
{NOT}                                               { return SpiceTypes.NOT; }
{PLUS_PLUS}                                         { return SpiceTypes.PLUS_PLUS; }
{MINUS_MINUS}                                       { return SpiceTypes.MINUS_MINUS; }
{PLUS_EQUAL}                                        { return SpiceTypes.PLUS_EQUAL; }
{MINUS_EQUAL}                                       { return SpiceTypes.MINUS_EQUAL; }
{MUL_EQUAL}                                         { return SpiceTypes.MUL_EQUAL; }
{DIV_EQUAL}                                         { return SpiceTypes.DIV_EQUAL; }
{SHL_EQUAL}                                         { return SpiceTypes.SHL_EQUAL; }
{SHR_EQUAL}                                         { return SpiceTypes.SHR_EQUAL; }
{SHL}                                               { return SpiceTypes.SHL; }
{SHR}                                               { return SpiceTypes.SHR; }
{PLUS}                                              { return SpiceTypes.PLUS; }
{MINUS}                                             { return SpiceTypes.MINUS; }
{MUL}                                               { return SpiceTypes.MUL; }
{DIV}                                               { return SpiceTypes.DIV; }
{REM}                                               { return SpiceTypes.REM; }
{GREATER}                                           { return SpiceTypes.GREATER; }
{LESS}                                              { return SpiceTypes.LESS; }
{GREATER_EQUAL}                                     { return SpiceTypes.GREATER_EQUAL; }
{LESS_EQUAL}                                        { return SpiceTypes.LESS_EQUAL; }
{EQUAL}                                             { return SpiceTypes.EQUAL; }
{NOT_EQUAL}                                         { return SpiceTypes.NOT_EQUAL; }
{ASSIGN_OP}                                         { return SpiceTypes.ASSIGN_OP; }
{QUESTION_MARK}                                     { return SpiceTypes.QUESTION_MARK; }
{SEMICOLON}                                         { return SpiceTypes.SEMICOLON; }
{COLON}                                             { return SpiceTypes.COLON; }
{COMMA}                                             { return SpiceTypes.COMMA; }
{DOT}                                               { return SpiceTypes.DOT; }
{BLOCK_COMMENT}                                     { return SpiceTypes.BLOCK_COMMENT; }
{LINE_COMMENT}                                      { return SpiceTypes.LINE_COMMENT; }
{WS}                                                { return TokenType.WHITE_SPACE; }
[^]                                                 { return TokenType.BAD_CHARACTER; }