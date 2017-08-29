import java.io.StringReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import utils.*;
import tree.*;


public final class Parser {

    // Stacks
    private static Stack<Symbol> symbols = new Stack<Symbol>(); // stack de simbolos
    private static Stack<Integer> states = new Stack<Integer>(); // stack de estados
    private static Stack<Expression> results = new Stack<Expression>(); // stack de resultados intermedios/finales


    // Limpia los stacks
    private static void clearStacks() {
        symbols.clear();
        states.clear();
        results.clear();
    }

    // hace pop n veces al stack de symbols y de states
    private static void pop(int n) {
        for(int i=0; i < n; i++) {
            states.pop();
            symbols.pop();
        }
    }

    /*
        FUNCIONES DE AYUDA AQUI, SI SON NECESARIAS
    */

    // funcion que hace una operacion
    private static void doOp(int production) {
        /*
            SU CODIGO AQUI
        */
    }

    // funcion que hace un shift
    private static void shift(Shift s, Symbol t) {
        /*
            SU CODIGO AQUI
        */
    }

    // funcion que hace un reduce
    private static void reduce(Reduce r) {
        /*
            SU CODIGO AQUI
        */
    }

    // function que hace un GOTO
    private static void goTo(GoTo g) {
        /*
            SU CODIGO AQUI
        */
    }

    // metodo principal, este lo llamamos cada vez que queres parsear algo
    public static Expression parse(Lexer lexer) throws IOException {
        clearStacks();
        states.push(0);
        symbols.push(new Symbol(Symbol.EOF));

        Symbol next = lexer.next();
        boolean accept = false;

        /*
            SU CODIGO AQUI
        */

        return null;
    }


    /***********************************************
     |       NO MODIFICAR A PARTIR DE AQUI         |
     ***********************************************/

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.print(">>> ");
            Lexer lexer = new Lexer(new StringReader(bf.readLine()));
            Expression e = parse(lexer);
            if(e != null) {
                System.out.println("= " + e.eval());
            }
        }
    }

}
