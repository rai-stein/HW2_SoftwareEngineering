public class Polynomial extends Function {
    private final int order;
    public double[] mekadmim;
    /* Constructor of the subClass Polynomial
     */
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
        for(int i = 1; i < this.order-1; i++){
            new_mekadmim[i] = this.mekadmim[i] * i;
        }
        return new Polynomial(new_mekadmim);
    }

    @Override
    public String toString(){
        StringBuilder toReturn = new StringBuilder("(");
        for(int i = 0; i < this.order; i++){
            double curr = this.mekadmim[i];
            if(curr != 0.0){
                if(curr == 1){
                    if(i == 0){
                        toReturn.append("1");
                    } else{
                        toReturn.append("x^").append(String.valueOf(i));
                    }
                }else{
                    toReturn.append(String.valueOf(curr)).append("x^").append(String.valueOf(i));
                }
                if(curr > 0.0) {
                    toReturn.append(" + ");
                }else{
                    toReturn.append(" - ");
                }
            }
        }
        toReturn.append("(");
        return toReturn.toString();
    }

}
