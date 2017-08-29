/*

    Laboratorio No. 5 - SLR(1) Parser
    CC4 - Compiladores


    S -> E; $
    E -> E + T
    E -> E - T
    E -> T
    T -> T * P
    T -> T / P
    T -> T % P
    T -> P
    P -> F ^ P
    P -> F
    F -> SIN A
    F -> COS A
    F -> TAN A
    A -> (E)
    A -> id

    ** id es un double en java:

    [0-9]+((".")[0-9]*)?([eE][+-]?[0-9]+)?

    ** Terminales:

    ;, +, -, *, /, %, ^, SIN, COS, TAN, (, ), ID

    ** Simbolo EOF/EOL:

    $
*/


import utils.Symbol;
import java.io.StringReader;
import java.io.IOException;

%%

%{
    public static void main(String[] args) throws IOException {
        String input = "";
        for(int i=0; i < args.length; i++) {
            input += args[i];
        }
        Lexer lexer = new Lexer(new StringReader(input));
        Symbol symbol;
        while((symbol = lexer.next()) != null) {
            System.out.println(symbol);
            if(symbol.equals(Symbol.EOF)) {
                break;
            }
        }
    }
%}

%eofval{
    return new Symbol(Symbol.EOF);
%eofval}

%public
%class Lexer
%function next
%type Symbol

SEMI = ";"
PLUS = "+"
MINUS = "-"
MULT = "*"
DIV = "/"
MOD = "%"
EXP = "^"
SIN = [sS][iI][nN]
COS = [cC][oO][sS]
TAN = [tT][aA][nN]
LPAREN = "("
RPAREN = ")"
ID = [0-9]+((".")[0-9]*)?([eE][+-]?[0-9]+)?
WHITE = (" "|\t|\n)

%%

<YYINITIAL>{SEMI}   { return new Symbol(Symbol.SEMI);   }

<YYINITIAL>{PLUS}   { return new Symbol(Symbol.PLUS);   }

<YYINITIAL>{MINUS}  { return new Symbol(Symbol.MINUS);  }

<YYINITIAL>{MULT}   { return new Symbol(Symbol.MULT);   }

<YYINITIAL>{DIV}    { return new Symbol(Symbol.DIV);    }

<YYINITIAL>{MOD}    { return new Symbol(Symbol.MOD);    }

<YYINITIAL>{EXP}    { return new Symbol(Symbol.EXP);    }

<YYINITIAL>{SIN}    { return new Symbol(Symbol.SIN);    }

<YYINITIAL>{COS}    { return new Symbol(Symbol.COS);    }

<YYINITIAL>{TAN}    { return new Symbol(Symbol.TAN);    }

<YYINITIAL>{LPAREN} { return new Symbol(Symbol.LPAREN); }

<YYINITIAL>{RPAREN} { return new Symbol(Symbol.RPAREN); }

<YYINITIAL>{ID}     { return new Symbol(Symbol.ID, yytext()); }

<YYINITIAL>{WHITE}  { /* NO HACER NADA */             }

<YYINITIAL>.        { return new Symbol(Symbol.ERROR);
                      /* todo lo demas es ERROR */ }
