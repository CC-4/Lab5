package tree;

// Clase que representa al nodo Tan
public class Tan extends Expression {

    private Expression e;

    public Tan(Expression e) {
        this.e = e;
    }

    public double eval() {
        return Math.tan(this.e.eval());
    }

}
