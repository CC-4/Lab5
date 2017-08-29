package tree;

// Clase que representa al nodo Mult
public class Mult extends Expression {

    private Expression e1;
    private Expression e2;

    public Mult(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public double eval() {
        return this.e1.eval() * this.e2.eval();
    }

}
