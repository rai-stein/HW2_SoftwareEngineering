public class Constant extends Function { //constant is a polynomial of order 0
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
    public Function derivative() {
        Constant zero = new Constant(0);
        return zero;
    }

}
