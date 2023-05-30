public class Negation extends Product {
    private Function function;
    public Negation(Function function){
        this.function = function;
    }

    @Override
    public double valueAt(double x) {
        return (-1)*function.valueAt(x);
    }

    @Override
    public String toString() {
        return "(-" + function.toString() + ")";
    }

    @Override
    public Function derivative() {
        Function prod = new Product(new Constant(-1),this.function);
        return prod.derivative();
    }
}
