public class Polynomial extends Function {
    private final int order;
    public double[] mekadmim;
    public Polynomial(double ... ai){
        this.order = ai.length;
        this.mekadmim = ai;
    }

    @Override
    public double valueAt(double x){
        double value = 0;
        for(int i = 0; i < this.order; i++){
            double pow = Math.pow(x, i);
            value += (mekadmim[i] * pow);
        }
        return value;
    }

    @Override
    public Function derivative() {
        double[] new_mekadmim = new double[this.order-1];
        for(int i = 1; i < this.order; i++){
            new_mekadmim[1] = this.mekadmim[i] * i;
        }
        return new Polynomial(new_mekadmim);
    }

    @Override
    public String toString(){
        StringBuilder toReturn = new StringBuilder(" ");
        for(int i = 0; i < this.order; i++){
            double curr = this.mekadmim[i];
            if(curr != 0.0){
                if(curr == 1){
                    toReturn.append("x^").append(String.valueOf(i));
                }else{
                    toReturn.append(String.valueOf(curr)).append("x^").append(String.valueOf(i));
                }
                if(curr > 0.0) {
                    toReturn.append("+");
                }else{
                    toReturn.append("-");
                }
            }
        }
        return toReturn.toString();
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        return 0;
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return 0;
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon){
        return 0;
    }

    @Override
    public double newtonRaphsonMethod(double a){
        return 0;
    }

    @Override
    public Function taylorPolynomial(int n){
        return null;
    }

}
