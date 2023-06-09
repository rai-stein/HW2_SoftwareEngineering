public class Constant extends Function { //constant is a polynomial of order 0
    private double constant;

    /**
     *
     * @param x
     */
    public Constant(double x){
        this.constant = x;
    }

    /**
     *
     * @param x
     * @return
     */
    @Override
    public double valueAt(double x) {
        return this.constant;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        if((int)this.constant == this.constant){
            return ("(" + (int)this.constant + ")");
        }
        return ("(" + this.constant+ ")");
    }

    /**
     *
     * @return
     */
    @Override
    public Function derivative() {
        Constant zero = new Constant(0);
        return zero;
    }

}
