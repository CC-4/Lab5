package tree;

// Clase que representa el nodo Cos
public class Cos extends Expression {

    private Expression e;

    public Cos(Expression e) {
        this.e = e;
    }

    public double eval() {
        return Math.cos(this.e.eval());
    }

}
