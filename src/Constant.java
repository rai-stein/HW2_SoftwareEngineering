package PACKAGE_NAME;public class Constant extends PACKAGE_NAME.Function {
    private double constant;
    public Constant(double x){
        this.constant = x;
    }

    @Override
    public double valueAt(double x) {
        return this.constant;
    }

    @Override
    public String toString() {
        return ("(" + this.constant+ ")");
    }

    @Override
    public PACKAGE_NAME.Function derivative() {
        Constant zero = new Constant(0);
        return zero;
    }
}
