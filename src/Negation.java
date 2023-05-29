package PACKAGE_NAME;public class Negation extends PACKAGE_NAME.Function {
    private PACKAGE_NAME.Function function;
    public Negation(PACKAGE_NAME.Function function){
        this.function = function;
    }

    @Override
    public double valueAt(double x) {
        return (-1)*function.valueAt(x);
    }

    @Override
    public String toString() {
        return "(-"+function.toString()+")";
    }

    @Override
    public PACKAGE_NAME.Function derivative() {
        PACKAGE_NAME.Function prod = new PACKAGE_NAME.Product(new PACKAGE_NAME.Constant(-1),this.function);
        return prod.derivative();
    }
}
