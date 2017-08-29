package tree;

// Clase que representa al nodo Sin
public class Sin extends Expression {

    private Expression e;

    public Sin(Expression e) {
        this.e = e;
    }

    public double eval() {
        return Math.sin(this.e.eval());
    }

}
