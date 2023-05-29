package PACKAGE_NAME;public class Difference extends PACKAGE_NAME.Function {
    private PACKAGE_NAME.Function function1;
    private PACKAGE_NAME.Function function2;

    public Difference(PACKAGE_NAME.Function function1, PACKAGE_NAME.Function function2){
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return this.function1.valueAt(x) - this.function2.valueAt(x);
    }

    @Override
    public String toString() {
        return "(" + this.function1.toString() + "-" + this.function2.toString() + ")";
    }

    @Override
    public PACKAGE_NAME.Function derivative() {
        PACKAGE_NAME.Function diff = new Difference(function1.derivative(), function2.derivative());

        return diff;
    }
}
