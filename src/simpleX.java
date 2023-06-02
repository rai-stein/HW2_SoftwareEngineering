public class simpleX extends Function {
    public simpleX(){}
    @Override
    public double valueAt(double x) {
        return x;
    }

    @Override
    public String toString() {
        return "x";
    }

    @Override
    public Function derivative() {
        Function one = new Constant(1);
        return one;
    }
}
