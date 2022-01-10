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
CHAR = '([^'\\\r\n]|\\(.|EOF))'
STRING = \"([^\"\\\r\n]|\\(.|EOF))*\"
INTEGER = -?[1-9]+[0-9]*|0
DOUBLE = -?[0-9]+.[0-9]+
IDENTIFIER = [_a-zA-Z][_a-zA-Z0-9]*
BLOCK_COMMENT = \/\*.*?\*\/
LINE_COMMENT = \/\/[^\r\n]*
ELLIPSIS = \.{3}
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
f                                                 { return SpiceTypes.F; }
p                                                 { return SpiceTypes.P; }
if                                                { return SpiceTypes.IF; }
else                                              { return SpiceTypes.ELSE; }
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
new                                               { return SpiceTypes.NEW; }
nil                                               { return SpiceTypes.NIL; }
main                                              { return SpiceTypes.MAIN; }
printf                                            { return SpiceTypes.PRINTF; }
sizeof                                            { return SpiceTypes.SIZEOF; }
ext                                               { return SpiceTypes.EXT; }
dll                                               { return SpiceTypes.DLL; }
true                                              { return SpiceTypes.TRUE; }
false                                             { return SpiceTypes.FALSE; }
{ELLIPSIS}                                        { return SpiceTypes.ELLIPSIS; }
{IDENTIFIER}                                      { return SpiceTypes.IDENTIFIER; }
{CHAR}                                            { return SpiceTypes.CHAR; }
{STRING}                                          { return SpiceTypes.STRING; }
{INTEGER}                                         { return SpiceTypes.INTEGER; }
{DOUBLE}                                          { return SpiceTypes.DOUBLE; }
\{                                                { return SpiceTypes.LBRACE; }
\}                                                { return SpiceTypes.RBRACE; }
\(                                                { return SpiceTypes.LPAREN; }
\)                                                { return SpiceTypes.RPAREN; }
\[                                                { return SpiceTypes.LBRACKET; }
\]                                                { return SpiceTypes.RBRACKET; }
\|\|                                              { return SpiceTypes.LOGICAL_OR; }
&&                                                { return SpiceTypes.LOGICAL_AND; }
\|                                                { return SpiceTypes.BITWISE_OR; }
&                                                 { return SpiceTypes.BITWISE_AND; }
\!                                                { return SpiceTypes.NOT; }
\+\+                                              { return SpiceTypes.PLUS_PLUS; }
--                                                { return SpiceTypes.MINUS_MINUS; }
\+=                                               { return SpiceTypes.PLUS_EQUAL; }
-=                                                { return SpiceTypes.MINUS_EQUAL; }
\*=                                               { return SpiceTypes.MUL_EQUAL; }
\/=                                               { return SpiceTypes.DIV_EQUAL; }
\<\<=                                             { return SpiceTypes.SHL_EQUAL; }
\>\>=                                             { return SpiceTypes.SHR_EQUAL; }
\<\<                                              { return SpiceTypes.SHL; }
\>\>                                              { return SpiceTypes.SHR; }
\+                                                { return SpiceTypes.PLUS; }
-                                                 { return SpiceTypes.MINUS; }
\*                                                { return SpiceTypes.MUL; }
\/                                                { return SpiceTypes.DIV; }
%                                                 { return SpiceTypes.REM; }
\>=                                               { return SpiceTypes.GREATER_EQUAL; }
\<=                                               { return SpiceTypes.LESS_EQUAL; }
\>                                                { return SpiceTypes.GREATER; }
\<                                                { return SpiceTypes.LESS; }
==                                                { return SpiceTypes.EQUAL; }
\!=                                               { return SpiceTypes.NOT_EQUAL; }
=                                                 { return SpiceTypes.ASSIGN_OP; }
\?                                                { return SpiceTypes.QUESTION_MARK; }
;                                                 { return SpiceTypes.SEMICOLON; }
:                                                 { return SpiceTypes.COLON; }
,                                                 { return SpiceTypes.COMMA; }
\.                                                { return SpiceTypes.DOT; }
{BLOCK_COMMENT}                                   { return SpiceTypes.BLOCK_COMMENT; }
{LINE_COMMENT}                                    { return SpiceTypes.LINE_COMMENT; }
{WS}                                              { return TokenType.WHITE_SPACE; }
[^]                                               { return TokenType.BAD_CHARACTER; }