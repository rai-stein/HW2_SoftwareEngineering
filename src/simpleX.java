package PACKAGE_NAME;public class simpleX extends PACKAGE_NAME.Function {
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
    public PACKAGE_NAME.Function derivative() {
        PACKAGE_NAME.Function one = new PACKAGE_NAME.Constant(1);
        return one;
    }
}
