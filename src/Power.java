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
        if(this.function.getClass() == Constant.class){
            return Double.toString(Math.pow(function.valueAt(0), this.pow));
        }
        if (this.function.getClass() == Constant.class && this.function.valueAt(0) == 0){
            return "";
        }

        return "("+this.function.toString()+"^"+Integer.toString(pow)+")";
    }

    @Override
    public Function derivative() {
        if (pow == 1) return function.derivative();
        Function prod = new MultiProduct(
                new Constant(this.pow),
                new Power(this.function,this.pow -1),
                this.function.derivative()
        );
        return prod;
    }
}
