package tree;

// Clase que representa al nodo Id
public class Id extends Expression {

    private double n;

    public Id(double n) {
        this.n = n;
    }

    public double eval() {
        return this.n;
    }

}
