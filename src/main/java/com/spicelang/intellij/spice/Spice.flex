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
CHAR_LITERAL = '(\\.|[^'\\])*'
STRING_LITERAL = \"(\\.|[^\"\\])*\"
INTEGER = [1-9][0-9]*|0
DOUBLE = [0-9]+.[0-9]+
SHORT = {INTEGER}s
LONG = {INTEGER}l
IDENTIFIER = [a-zA-Z_][a-zA-Z0-9_]*
BLOCK_COMMENT = "/*"([^*] | (\*+[^*/]))*\*+\/
LINE_COMMENT = "//".*
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
signed                                            { return SpiceTypes.SIGNED; }
unsigned                                          { return SpiceTypes.UNSIGNED; }
public                                            { return SpiceTypes.PUBLIC; }
f                                                 { return SpiceTypes.F; }
p                                                 { return SpiceTypes.P; }
if                                                { return SpiceTypes.IF; }
else                                              { return SpiceTypes.ELSE; }
assert                                            { return SpiceTypes.ASSERT; }
for                                               { return SpiceTypes.FOR; }
foreach                                           { return SpiceTypes.FOREACH; }
while                                             { return SpiceTypes.WHILE; }
const                                             { return SpiceTypes.CONST; }
import                                            { return SpiceTypes.IMPORT; }
break                                             { return SpiceTypes.BREAK; }
continue                                          { return SpiceTypes.CONTINUE; }
return                                            { return SpiceTypes.RETURN; }
as                                                { return SpiceTypes.AS; }
struct                                            { return SpiceTypes.STRUCT; }
type                                              { return SpiceTypes.TYPE; }
thread                                            { return SpiceTypes.THREAD; }
unsafe                                            { return SpiceTypes.UNSAFE; }
//new                                               { return SpiceTypes.NEW; }
nil                                               { return SpiceTypes.NIL; }
main                                              { return SpiceTypes.MAIN; }
printf                                            { return SpiceTypes.PRINTF; }
sizeof                                            { return SpiceTypes.SIZEOF; }
len                                               { return SpiceTypes.LEN; }
tid                                               { return SpiceTypes.TID; }
join                                              { return SpiceTypes.JOIN; }
ext                                               { return SpiceTypes.EXT; }
dll                                               { return SpiceTypes.DLL; }
inline                                            { return SpiceTypes.INLINE; }
true                                              { return SpiceTypes.TRUE; }
false                                             { return SpiceTypes.FALSE; }
{IDENTIFIER}                                      { return SpiceTypes.IDENTIFIER; }
{CHAR_LITERAL}                                    { return SpiceTypes.CHAR_LITERAL; }
{STRING_LITERAL}                                  { return SpiceTypes.STRING_LITERAL; }
{INTEGER}                                         { return SpiceTypes.INTEGER; }
{SHORT}                                           { return SpiceTypes.SHORT; }
{LONG}                                            { return SpiceTypes.LONG; }
{DOUBLE}                                          { return SpiceTypes.DOUBLE; }
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
"<<"                                              { return SpiceTypes.SHL; }
">>"                                              { return SpiceTypes.SHR; }
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
"..."                                             { return SpiceTypes.ELLIPSIS; }
{LINE_COMMENT}                                    { return SpiceTypes.LINE_COMMENT; }
{BLOCK_COMMENT}                                   { return SpiceTypes.BLOCK_COMMENT; }
{WS}                                              { return TokenType.WHITE_SPACE; }
[^]                                               { return TokenType.BAD_CHARACTER; }