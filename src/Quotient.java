public class Quotient extends Function {
    private Function function1;
    private Function function2;
    public Quotient(Function function1, Function function2){
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return (this.function1.valueAt(x))/(this.function2.valueAt(x));
    }

    @Override
    public String toString() {
        return "(" + this.function1.toString() + " / " + this.function2.toString() + ")";
    }

    /**
     *
     * @return
     */
    @Override
    public Function derivative() {
        Function quo = new Quotient(
                new Difference(
                        new Product(this.function1.derivative(), this.function2 ),
                                new Product(
                                        this.function2.derivative(),this.function1
                                )
                        ),
                new Power(this.function2,2)
        );
        return quo;
    }

}
