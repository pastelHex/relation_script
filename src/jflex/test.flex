/* The consists of three parts, seperated by the  delimiter.
 * Text up to the first  is copied verbatim into the created source file.
 * Used for package and import statements. (we don't need any here)
 */
import java_cup.runtime.Symbol;

%%

%cup
/* The next section is for options and macros. Things defined here can be used
 * in the next rules section.
 */

/* The class will be called TestLexer */
%class TestLexer

/* what return yylex() method */

//%type String

/* error to throw */
%scanerror RuntimeException

%unicode
/* Code in the next section is copied into the generated lexer class.
 */
%{
%}

/* Here we define some macros, which are abbriviations for regular expressions.
 */

VARIABLE    =   [a-z]+[0-9]*
RELATION    =   "*"[A-Z]+"*"
BRACKET_L   =   "{"
BRACKET_R   =   "}"
GT          =   ">"
LT          =   "<"
WHITESPACE  =   \r|\n|\r\n | [ \t\f]
NUMBER      =   [1-9][0-9]*

%state STRING

%%

<YYINITIAL> "is"                {System.out.println("IS"); return new Symbol(sym.IS);}
<YYINITIAL> {VARIABLE}          {System.out.println("VARIABLE "+ yytext()); return new Symbol(sym.VAR, yytext());}
<YYINITIAL> {RELATION}          {System.out.println("RELATION "+ yytext()); return new Symbol(sym.REL, yytext());}
<YYINITIAL> {WHITESPACE}        {/*ignore*/}
<YYINITIAL> {BRACKET_L}         {return new Symbol(sym.L_BRA);}
<YYINITIAL> {BRACKET_R}         {return new Symbol(sym.R_BRA);}
<YYINITIAL> {GT}                {return new Symbol(sym.GT);}
<YYINITIAL> {LT}                {return new Symbol(sym.LT);}
<YYINITIAL> {NUMBER}            {return new Symbol(sym.NUMBER, Integer.parseInt(yytext()));}


[^]                             { throw new RuntimeException("Illegal character <" + yytext() + ">"); }

/*  var1*RELATION*var2{ var1 > var2}       rel_def
    a is 5RELATION6;                        STATEMENT
    5RELATION4                              EXPR
*/