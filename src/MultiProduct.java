public class MultiProduct extends Function {
    public int numFunc;
    public Function[] toTimes;
    public MultiProduct(Function func1, Function func2, Function ... functions){
        this.numFunc = functions.length;
        this.toTimes = new Function[this.numFunc + 2];
        this.toTimes[0] = func1;
        this.toTimes[1] = func2;
        for(int i = 0; i < this.numFunc; i++){
            toTimes[2 + i] = functions[i];
        }
    }

    @Override
    public double valueAt(double x) {
        double toReturn = 1;
        for (Function function : this.toTimes) {
            toReturn *= function.valueAt(x);
        }
        return toReturn;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder("(");
        for (int i = 0; i < this.toTimes.length; i++){
            toReturn.append(toTimes[i].toString());
            if(i != this.toTimes.length-1){
                toReturn.append("*");
            }
        }
        toReturn.append(")");
        return toReturn.toString();
    }

    @Override
    public Function derivative() {



        return null;



    }
}
