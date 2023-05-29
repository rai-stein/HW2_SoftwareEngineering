package PACKAGE_NAME;public class Power  extends PACKAGE_NAME.Function {
    private PACKAGE_NAME.Function function;
    private int pow;

    public Power(PACKAGE_NAME.Function func, int pow){
        this.function = func;
        this.pow = pow;
    }

    @Override
    public double valueAt(double x) {

        return Math.pow(this.function.valueAt(x), this.pow);

    }

    @Override
    public String toString() {
        return this.function.toString()+"^"+Double.toString(pow);
    }

    @Override
    public PACKAGE_NAME.Function derivative() {
        PACKAGE_NAME.Function prod = new PACKAGE_NAME.Product(
                new PACKAGE_NAME.Constant(this.pow),
                new Power(this.function,this.pow -1)
        );
        return prod;

    }
}
