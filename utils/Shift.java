package utils;

/*
    Shift es una clase que implementa el Shift de la tabla de parseo, esta
    guarda la informacion del estado al que tenemos que ir si estamos en un estado s
    y el siguiente simbolo de entrada es c.

    Shift(5) -> representa un shift hacia el estado 5

    para obtener el estado al que se tiene que ir simplemente utilizamos:

    getState()
*/

public class Shift {

    private int state;

    // Constructor de la clase
    public Shift(int state) {
        this.state = state;
    }

    // Metodo que nos devuelve el estado al que tenemos que ir
    public int getState() {
        return this.state;
    }

    public String toString() {
        return "S(" + this.state +")";
    }

}
