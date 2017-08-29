package utils;

/*
    Esta clase implementa un reduce de la tabla de parseo, esta guarda la informacion
    de como tenemos que reducir el stack de simbolos.

    Ejemplo:

    1. X -> (X)$
    2. X -> A
    3. A -> id

    si tuvieramos en el stack de simbolos [(, X, )] y el siguiente simbolo de entrada es $,
    tendriamos que hacer un reduce de 1, Reduce(1), convirtiendo el stack de simbolos en
    [X].

    esta clase tiene metodos bastante utiles como por ejemplo:

    getProduction() nos devuelve la produccion que escogimos
    getProductionSymbol() nos devuelve el simbolo al que deberiamos de reducir.
    isID() nos dice si la produccion a reducir es del tipo A -> id
    isOp() nos dice si la produccion a reducir es del tipo A -> X op Y
    getPops() nos devuelve la cantidad de pops que habria que hacerle al stack de simbolos
*/

public class Reduce {

    private int production;

    // Constructor
    public Reduce(int production) {
        this.production = production;
    }

    // Metodo que nos devuelve el numero de produccion que tenemos que utilizar
    public int getProduction() {
        return this.production;
    }

    // Metodo que nos devuelve el simbolo al que tenemos que reducir
    public Symbol getProductionSymbol() {
        switch(this.production) {
            case 1: return new Symbol(Symbol.S);
            case 2: case 3: case 4: return new Symbol(Symbol.E);
            case 5: case 6: case 7: case 8: return new Symbol(Symbol.T);
            case 9: case 10: return new Symbol(Symbol.P);
            case 11: case 12: case 13: case 14: return new Symbol(Symbol.F);
            case 15: case 16: return new Symbol(Symbol.A);
            default: return null;
        }
    }

    // Metodo que nos devuelve true si la produccion a reducir es de tipo A -> id
    public boolean isID() {
        return this.production == 16;
    }

    // Metodo que nos devuelve true si la produccion a reducir es de tipo A -> X op Y
    public boolean isOp() {
        switch(this.production) {
            case 2: case 3: case 5:
            case 6: case 7: case 9:
            case 11: case 12: case 13: return true;
            default: return false;
        }
    }

    // Metodo que nos devuelve el numero de pops que tendriamos que hacer al reducir
    public int getPops() {
        switch(this.production) {
            case 4: case 8: case 10: case 14: case 16: return 1;
            case 11: case 12: case 13: return 2;
            case 2: case 3: case 5: case 6: case 7: case 9: case 15: return 3;
            case 1: default: return 0;
        }
    }

    public String toString() {
        return "R(" + this.production +")";
    }

}
