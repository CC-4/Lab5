package tree;

// Clase que representa el nodo Exp
public class Exp extends Expression {

    private Expression e1;
    private Expression e2;

    public Exp(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public double eval() {
        return Math.pow(this.e1.eval(), this.e2.eval());
    }

}
