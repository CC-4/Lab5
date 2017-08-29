package utils;

/*
    GoTo es una clase que implementa el GoTo de la tabla de parseo, esta
    guarda la informacion del estado al que tenemos que ir si el stack de estados y
    el stack de simbolos no estan balanceados y si el top del stack de simbolos es un
    simbolo gramatical NO-TERMINAL.


    GoTo(5) -> representa un goto hacia el estado 5

    para obtener el estado al que se tiene que ir simplemente utilizamos:

    getState()
*/


public class GoTo {

    private int state;

    // Constructor de la clase
    public GoTo(int state) {
        this.state = state;
    }

    // Metodo que nos devuelve el estado al que tenemos que ir
    public int getState() {
        return this.state;
    }

    public String toString() {
        return "G(" + this.state +")";
    }

}
