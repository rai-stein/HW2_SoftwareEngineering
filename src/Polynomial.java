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
        if(this.order == 1) return new Constant(mekadmim[0]);
        double[] new_mekadmim = new double[this.order-1];
        for(int i = 1; i < this.order-1; i++){
            new_mekadmim[i] = this.mekadmim[i] * i;
        }
        return new Polynomial(new_mekadmim);
    }

    @Override
    public String toString(){
        String toReturn = "(";
        for(int i = 0; i < this.order; i++){
            double curr = this.mekadmim[i];
            boolean isInt = false;
            if((int)curr == curr){
                curr = (int)curr;
                isInt = true;
            }
            if(curr == 0){
                continue;
            }
            if(!toReturn.equals("(")){
                if(curr > 0) toReturn += " + ";
            }
            if((i == 0) && isInt){
                toReturn += String.valueOf(curr);
            }else if((i == 0) && !isInt){
                toReturn += String.valueOf(curr);
                continue;
            }
            if((i == 1) && isInt){
                toReturn += String.valueOf(curr) + "x";
            }else if((i == 1) && !isInt){
                toReturn += String.valueOf(curr) + "x";
                continue;
            }
            if(curr == 1){
                toReturn += "x^" + String.valueOf(i);
            }else if(curr == -1){
                toReturn += "-x^" + String.valueOf(i);
                continue;
            }
            if(isInt){
                toReturn += String.valueOf(curr) + "x^" + String.valueOf(i);
            }else {
                toReturn += String.valueOf(curr) + "x^" + String.valueOf(i);
            }
        }
        return toReturn;
    }

}
