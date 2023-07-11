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
DEC_LIT = ([0][dD])?[0-9]+
BIN_LIT = [0][bB][01]+
HEX_LIT = [0][xXhH][0-9a-fA-F]+
OCT_LIT = [0][oO][0-7]+
NUM_LIT = {NUM_LIT_S}|{NUM_LIT_U}
NUM_LIT_S = [-]({DEC_LIT}|{BIN_LIT}|{HEX_LIT}|{OCT_LIT})
NUM_LIT_U = ({DEC_LIT}|{BIN_LIT}|{HEX_LIT}|{OCT_LIT})[u]?

DOUBLE_LIT = [-]?[0-9]*[.][0-9]+([eE][+-]?[0-9]+)?
INT_LIT = {NUM_LIT}
SHORT_LIT = {NUM_LIT}s
LONG_LIT = {NUM_LIT}l
CHAR_LIT = '(\\.|[^'\\])*'
STRING_LIT = \"(\\.|[^\"\\])*\"
IDENTIFIER = [a-z_][a-zA-Z0-9_]*
TYPE_IDENTIFIER = [A-Z][a-zA-Z0-9_]*

DOC_COMMENT = "/**"([^*] | (\*+[^*/]))*\*+\/
LINE_COMMENT = "//".*
BLOCK_COMMENT = "/*"([^*] | (\*+[^*/]))*\*+\/
WS = [ \t\r\n]+

%%

double                                            { return SpiceTypes.TYPE_DOUBLE; }
int                                               { return SpiceTypes.TYPE_INT; }
short                                             { return SpiceTypes.TYPE_SHORT; }
long                                              { return SpiceTypes.TYPE_LONG; }
byte                                              { return SpiceTypes.TYPE_BYTE; }
char                                              { return SpiceTypes.TYPE_CHAR; }
string                                            { return SpiceTypes.TYPE_STRING; }
bool                                              { return SpiceTypes.TYPE_BOOL; }
dyn                                               { return SpiceTypes.TYPE_DYN; }
const                                             { return SpiceTypes.CONST; }
signed                                            { return SpiceTypes.SIGNED; }
unsigned                                          { return SpiceTypes.UNSIGNED; }
inline                                            { return SpiceTypes.INLINE; }
public                                            { return SpiceTypes.PUBLIC; }
heap                                              { return SpiceTypes.HEAP; }
f                                                 { return SpiceTypes.F; }
p                                                 { return SpiceTypes.P; }
if                                                { return SpiceTypes.IF; }
else                                              { return SpiceTypes.ELSE; }
assert                                            { return SpiceTypes.ASSERT; }
for                                               { return SpiceTypes.FOR; }
foreach                                           { return SpiceTypes.FOREACH; }
do                                                { return SpiceTypes.DO; }
while                                             { return SpiceTypes.WHILE; }
import                                            { return SpiceTypes.IMPORT; }
break                                             { return SpiceTypes.BREAK; }
continue                                          { return SpiceTypes.CONTINUE; }
return                                            { return SpiceTypes.RETURN; }
as                                                { return SpiceTypes.AS; }
struct                                            { return SpiceTypes.STRUCT; }
interface                                         { return SpiceTypes.INTERFACE; }
type                                              { return SpiceTypes.TYPE; }
enum                                              { return SpiceTypes.ENUM; }
operator                                          { return SpiceTypes.OPERATOR; }
alias                                             { return SpiceTypes.ALIAS; }
unsafe                                            { return SpiceTypes.UNSAFE; }
//new                                               { return SpiceTypes.NEW; }
nil                                               { return SpiceTypes.NIL; }
main                                              { return SpiceTypes.MAIN; }
printf                                            { return SpiceTypes.PRINTF; }
sizeof                                            { return SpiceTypes.SIZEOF; }
alignof                                           { return SpiceTypes.ALIGNOF; }
len                                               { return SpiceTypes.LEN; }
ext                                               { return SpiceTypes.EXT; }
true                                              { return SpiceTypes.TRUE; }
false                                             { return SpiceTypes.FALSE; }
{IDENTIFIER}                                      { return SpiceTypes.IDENTIFIER; }
{TYPE_IDENTIFIER}                                 { return SpiceTypes.TYPE_IDENTIFIER; }
{CHAR_LIT}                                        { return SpiceTypes.CHAR_LIT; }
{STRING_LIT}                                      { return SpiceTypes.STRING_LIT; }
{INT_LIT}                                         { return SpiceTypes.INT_LIT; }
{SHORT_LIT}                                       { return SpiceTypes.SHORT_LIT; }
{LONG_LIT}                                        { return SpiceTypes.LONG_LIT; }
{DOUBLE_LIT}                                      { return SpiceTypes.DOUBLE_LIT; }
"{"                                               { return SpiceTypes.LBRACE; }
"}"                                               { return SpiceTypes.RBRACE; }
"("                                               { return SpiceTypes.LPAREN; }
")"                                               { return SpiceTypes.RPAREN; }
"["                                               { return SpiceTypes.LBRACKET; }
"]"                                               { return SpiceTypes.RBRACKET; }
"||"                                              { return SpiceTypes.LOGICAL_OR; }
&&                                                { return SpiceTypes.LOGICAL_AND; }
"|"                                               { return SpiceTypes.BITWISE_OR; }
"^"                                               { return SpiceTypes.BITWISE_XOR; }
"&"                                               { return SpiceTypes.BITWISE_AND; }
"++"                                              { return SpiceTypes.PLUS_PLUS; }
"--"                                              { return SpiceTypes.MINUS_MINUS; }
"+="                                              { return SpiceTypes.PLUS_EQUAL; }
"-="                                              { return SpiceTypes.MINUS_EQUAL; }
"*="                                              { return SpiceTypes.MUL_EQUAL; }
"/="                                              { return SpiceTypes.DIV_EQUAL; }
"%="                                              { return SpiceTypes.REM_EQUAL; }
"<<="                                             { return SpiceTypes.SHL_EQUAL; }
">>="                                             { return SpiceTypes.SHR_EQUAL; }
"&="                                              { return SpiceTypes.AND_EQUAL; }
"|="                                              { return SpiceTypes.OR_EQUAL; }
"^="                                              { return SpiceTypes.XOR_EQUAL; }
"+"                                               { return SpiceTypes.PLUS; }
"-"                                               { return SpiceTypes.MINUS; }
"*"                                               { return SpiceTypes.MUL; }
"/"                                               { return SpiceTypes.DIV; }
"%"                                               { return SpiceTypes.REM; }
"!"                                               { return SpiceTypes.NOT; }
"~"                                               { return SpiceTypes.BITWISE_NOT; }
">"                                               { return SpiceTypes.GREATER; }
"<"                                               { return SpiceTypes.LESS; }
">="                                              { return SpiceTypes.GREATER_EQUAL; }
"<="                                              { return SpiceTypes.LESS_EQUAL; }
"=="                                              { return SpiceTypes.EQUAL; }
"!="                                              { return SpiceTypes.NOT_EQUAL; }
"="                                               { return SpiceTypes.ASSIGN; }
"?"                                               { return SpiceTypes.QUESTION_MARK; }
";"                                               { return SpiceTypes.SEMICOLON; }
":"                                               { return SpiceTypes.COLON; }
","                                               { return SpiceTypes.COMMA; }
"."                                               { return SpiceTypes.DOT; }
"::"                                              { return SpiceTypes.SCOPE_ACCESS; }
"..."                                             { return SpiceTypes.ELLIPSIS; }
"#"                                               { return SpiceTypes.FCT_ATTR_PREAMBLE; }
"#!"                                              { return SpiceTypes.MOD_ATTR_PREAMBLE; }
{DOC_COMMENT}                                     { return SpiceTypes.DOC_COMMENT; }
{LINE_COMMENT}                                    { return SpiceTypes.LINE_COMMENT; }
{BLOCK_COMMENT}                                   { return SpiceTypes.BLOCK_COMMENT; }
{WS}                                              { return TokenType.WHITE_SPACE; }
[^]                                               { return TokenType.BAD_CHARACTER; }