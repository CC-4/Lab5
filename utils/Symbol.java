package utils;

public final class Symbol {

    /*
        ID's de los Symbols
    */
    public static final int SEMI   =  0; // -> ;
    public static final int PLUS   =  1; // -> +
    public static final int MINUS  =  2; // -> -
    public static final int MULT   =  3; // -> *
    public static final int DIV    =  4; // -> /
    public static final int MOD    =  5; // -> %
    public static final int EXP    =  6; // -> ^
    public static final int SIN    =  7; // -> SIN
    public static final int COS    =  8; // -> COS
    public static final int TAN    =  9; // -> TAN
    public static final int LPAREN = 10; // -> (
    public static final int RPAREN = 11; // -> )
    public static final int ID     = 12; // -> id (number)
    public static final int EOF    = 13; // Final del string
    public static final int S      = 14; // simbolo gramatical S
    public static final int E      = 15; // simbolo gramatical E
    public static final int T      = 16; // simbolo gramatical T
    public static final int P      = 17; // simbolo gramatical P
    public static final int F      = 18; // simbolo gramatical F
    public static final int A      = 19; // simbolo gramatical A
    public static final int ERROR  = 20; // ERROR

    // Esto sirve para representar el Symbol con un string, akdsjasjdlk bastante util
    public static final String[] names = {
        ";",
        "+",
        "-",
        "*",
        "/",
        "%",
        "^",
        "SIN",
        "COS",
        "TAN",
        "(",
        ")",
        "ID",
        "$",
        "S",
        "E",
        "T",
        "P",
        "F",
        "A",
        "ERROR"
    };

    private int id;
    private String val;

    // Constructor para guardar el Symbol de tipo ID (Solo lexer lo utiliza)
    public Symbol(int id, String val) {
        this.id = id;
        this.val = val;
    }

    // Constructor para guardar los demas Symbols
    public Symbol(int id) {
        this(id, null);
    }

    // Para comparar
    public boolean equals(int id) {
        return this.id == id;
    }

    // Nos devuelve la posicion del simbolo en la tabla de parseo, es decir la columna que representa (x)
    public int getPos() {
        return this.id;
    }

    // Nos devuelve el valor del symbol(double) si es es un Id, NO USAR ESTO EN OTRA OCASION
    public double getVal() {
        return Double.parseDouble(this.val);
    }

    public String toString() {
        String s = Symbol.names[this.id];
        if(this.val != null) {
            s += " = " + this.val;
        }
        return s;
    }

}
