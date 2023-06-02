public class Difference extends Function {
    private Function function1;
    private Function function2;

    public Difference(Function function1, Function function2){
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return this.function1.valueAt(x) - this.function2.valueAt(x);
    }

    @Override
    public String toString() {
        return "(" + this.function1.toString() + " - " + this.function2.toString() + ")";
    }

    @Override
    public Function derivative() {
        return new Difference(function1.derivative(), function2.derivative());
    }
}
