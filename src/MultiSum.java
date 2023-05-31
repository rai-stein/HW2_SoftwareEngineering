public class MultiSum extends Function {
    public int numFunc;
    public Function[] toAdd;

    public MultiSum(Function func1, Function func2, Function ... functions){
        this.numFunc = functions.length+2;
        this.toAdd = new Function[this.numFunc];
        this.toAdd[0] = func1;
        this.toAdd[1] = func2;
        for(int i = 0; i < this.numFunc-2; i++){
            toAdd[2 + i] = functions[i];
        }
    }

    @Override
    public double valueAt(double x) {
        double toReturn = 0;
        for (int i = 0; i<this.numFunc; i++) {
            toReturn += this.toAdd[i].valueAt(x);
        }
        return toReturn;
    }

    @Override
    public String toString() {

        StringBuilder toReturn = new StringBuilder("(");
        for (int i = 0; i < this.toAdd.length; i++){
            toReturn.append(toAdd[i].toString());
            if(i != this.toAdd.length - 1){
                toReturn.append("+");
            }
        }
        toReturn.append(")");
        return toReturn.toString();
    }

    @Override
    public Function derivative() {

        Function[] derivatives = new Function[this.toAdd.length];
        for(int i = 0; i < this.toAdd.length; i++){
            derivatives[i] = this.toAdd[i].derivative();
        }
        Function[] derivativesLeft = new Function[this.toAdd.length - 2];
        for(int i = 0; i < this.toAdd.length-2; i++){
            derivativesLeft[i] = derivatives[i+2];
        }
        return new MultiSum(derivatives[0], derivatives[1], derivativesLeft);
    }

}
