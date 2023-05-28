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
}
