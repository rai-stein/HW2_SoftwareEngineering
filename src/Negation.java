public class Negation extends Function {
    Function function;

    public Negation(Function func){
        this.function = func;
    }

    @Override
    public double valueAt(double x) {
        return (-1)*this.function.valueAt(x);
    }

    @Override
    public String toString() {
        return "(-"+this.function.toString()+")";
    }

    @Override
    public Function derivative() {
        return new Negation(this.function.derivative());
    }
}

