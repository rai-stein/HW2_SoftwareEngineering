public class Power extends Function {
    private Function function;
    private int pow;

    public Power(Function func, int pow){
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
    public Function derivative() {
        Function prod = new Product(
                new Constant(this.pow),
                new Power(this.function,this.pow -1)
        );
        return prod;
    }
}
