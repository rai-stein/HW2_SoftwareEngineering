package PACKAGE_NAME;public class Sum extends PACKAGE_NAME.Function {
    private PACKAGE_NAME.Function function1;
    private PACKAGE_NAME.Function function2;
    public Sum(PACKAGE_NAME.Function function1, PACKAGE_NAME.Function function2){
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return function1.valueAt(x)+function2.valueAt(x);
    }

    @Override
    public String toString() {
        return "(" + function1.toString() + "+" + function2.toString() + ")";
    }

    @Override
    public PACKAGE_NAME.Function derivative() {
        PACKAGE_NAME.Function newSum = new Sum(function1.derivative(), function2.derivative());
        return newSum;
    }
}
