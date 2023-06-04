public class MultiSum extends Function {
    public int numFunc;
    public Function[] toAdd;

    public MultiSum(Function func1, Function func2, Function ... functions){
        this.numFunc = functions.length;
        this.toAdd = new Function[this.numFunc + 2];
        this.toAdd[0] = func1;
        this.toAdd[1] = func2;
        for(int i = 0; i < this.numFunc; i++){
            toAdd[2 + i] = functions[i];
        }
    }

    @Override
    public double valueAt(double x) {
        double toReturn = 0;
        for (Function function : this.toAdd) {
            if (function != null)            toReturn += function.valueAt(x);

        }
        return toReturn;
    }

    @Override
    public String toString() {

        String toReturn = "(" + this.toAdd[0].toString();
        for (int i = 1; i < this.toAdd.length; i++){
            if (this.toAdd[i] == null) continue;
            toReturn += " + " + this.toAdd[i].toString();
        }
        toReturn += ")";
        return toReturn.toString();
    }

    @Override
    public Function derivative() {
        Function[] derivatives = new Function[this.toAdd.length];
        for(int i = 0; i < this.toAdd.length; i++){
            if(this.toAdd[i] == null) continue;
            derivatives[i] = this.toAdd[i].derivative();
        }
        Function[] derivativesLeft = new Function[this.toAdd.length - 2];
        for(int i = 0; i < this.toAdd.length-2; i++){
            derivativesLeft[i] = derivatives[i+2];
        }
        return new MultiSum(derivatives[0], derivatives[1], derivativesLeft);
    }

}
