package PACKAGE_NAME;public class Quotient extends PACKAGE_NAME.Function {
    private PACKAGE_NAME.Function function1;
    private PACKAGE_NAME.Function function2;
    public Quotient(PACKAGE_NAME.Function function1, PACKAGE_NAME.Function function2){
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double x) {
        return (this.function1.valueAt(x))/(this.function2.valueAt(x));
    }

    @Override
    public String toString() {
        return "(" + this.function1.toString() + ")/(" + this.function2.toString() + ")";
    }

    @Override
    public PACKAGE_NAME.Function derivative() {
        PACKAGE_NAME.Function quo = new Quotient(
                new PACKAGE_NAME.Difference(
                        new PACKAGE_NAME.Product(this.function1.derivative(), this.function2 ),
                                new PACKAGE_NAME.Product(
                                        this.function1,this.function2.derivative()
                                )
                        ),
                new PACKAGE_NAME.Power(this.function2,2)
        );
        return quo;
    }
}
