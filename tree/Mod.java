package tree;

// Clase que representa al nodo Mod
public class Mod extends Expression {

    private Expression e1;
    private Expression e2;

    public Mod(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public double eval() {
        double t = this.e1.eval();
        return t - (t / this.e2.eval());
    }

}
