/* The consists of three parts, seperated by the  delimiter.
 * Text up to the first  is copied verbatim into the created source file.
 * Used for package and import statements. (we don't need any here)
 */
import common.RelationRepository;import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java.lang.*;

%%


/* The next section is for options and macros. Things defined here can be used
 * in the next rules section.
 */

/* The class will be called TestLexer */
%class TestLexer
%cup
%char
%line
%column
//%implements sym
%public
/* what return yylex() method */

//%type String

/* error to throw */
%scanerror RuntimeException

%unicode
/* Code in the next section is copied into the generated lexer class.
 */
%{

	public TestLexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }

    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code,
						new Location(yyline+1, yycolumn +1, yychar),
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }

    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }

    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" +
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}

/* Here we define some macros, which are abbriviations for regular expressions.
 */

VARIABLE        =   [a-z]+([a-z]|[0-9])*
//RELATION        =   [A-Z]+([A-Z]|[0-9])*
SET_VAR         =   [A-Z]+([A-Z]|[0-9])*
BRACKET_L       =   "{"
BRACKET_R       =   "}"
GT              =   ">"
LT              =   "<"
GT_EQ           =   ">="
LT_EQ           =   "<="
EQ              =   "=="
NOT_EQ          =   "!="
WHITESPACE      =   \r|\n|\r\n | [ \t\f]
NUMBER          =   [1-9][0-9]*
SET_OPERATOR   =   "+"|"-"|"\\"
SET_DELI        =   ","
SEMI            =   ";"
DEF             =   "DEF:"

%state STRING

%%

<YYINITIAL> "is"                { return symbolFactory.newSymbol("IS",sym.IS);}
<YYINITIAL> {VARIABLE}          {return symbolFactory.newSymbol("VARIABLE",sym.VAR, yytext());}
//<YYINITIAL> {RELATION}          { return symbolFactory.newSymbol("RELATION",sym.REL, yytext());}
<YYINITIAL> {WHITESPACE}        {/*ignore*/}
<YYINITIAL> {BRACKET_L}         {return symbolFactory.newSymbol("BRACKET_L",sym.L_BRA);}
<YYINITIAL> {BRACKET_R}         {return symbolFactory.newSymbol("BRACKET_R",sym.R_BRA);}

 //VAR OPERATORS
<YYINITIAL> {GT}                {return symbolFactory.newSymbol("GT",sym.GT);}
<YYINITIAL> {LT}                {return symbolFactory.newSymbol("LT",sym.LT);}
<YYINITIAL> {GT_EQ}             {return symbolFactory.newSymbol("GT_EQ",sym.GT_EQ);}
<YYINITIAL> {LT_EQ}             {return symbolFactory.newSymbol("LT_EQ",sym.LT_EQ);}
<YYINITIAL> {EQ}                {return symbolFactory.newSymbol("EQ",sym.EQ);}
<YYINITIAL> {NOT_EQ}            {return symbolFactory.newSymbol("NOT_EQ",sym.NOT_EQ);}

<YYINITIAL> {NUMBER}            {return symbolFactory.newSymbol("NUMBER",sym.NUMBER, Integer.parseInt(yytext()));}
<YYINITIAL> {SET_VAR}           {String capsName = yytext();
                                 if(RelationRepository.isThereRelation(capsName)){
                                     return symbolFactory.newSymbol("SET_VAR",sym.REL, yytext());
                                 }else{
                                     return symbolFactory.newSymbol("SET_VAR",sym.SET_VAR, capsName);
                                     }}
<YYINITIAL> {SET_OPERATOR}     {return symbolFactory.newSymbol("SET_OPERATOR",sym.SET_OPERATOR, yytext());}
<YYINITIAL> {SET_DELI}          {return symbolFactory.newSymbol("SET_DELI",sym.SET_DELI);}
<YYINITIAL> {SEMI}              {return symbolFactory.newSymbol("SEMI",sym.SEMI);}
<YYINITIAL> {DEF}               {return symbolFactory.newSymbol("DEF",sym.REL_DEFINITION);}

[^]                             { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
//[^]                             { throw new RuntimeException("Illegal character <" + yytext() + ">"); }

/*  var1*RELATION*var2{ var1 > var2}       rel_def
    a is 5RELATION6;                        STATEMENT
    ZBIÓR is {a,c,v,b,n}                    statment
    var1 > var2                             statment_def
    5*RELATION*4                              EXPR
     Z+G                                        expr
    A is Z+G; Z\G                            statment    set? statment? set_expr! -> set terminal

*/