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
    Function[] tempArray  = removeItem(this.toTimes,0,1);
    Function temp1 = new MultiProduct(this.toTimes[0].derivative(),this.toTimes[1],tempArray );
    Function temp2 = new MultiProduct(this.toTimes[1].derivative(),this.toTimes[0],this.toTimes);
    Function[] derArray = new Function[numFunc-2];
    for (int i = 2 ; i<this.numFunc; i++){
        tempArray = removeItem(this.toTimes,0,i);
        derArray[0] = new MultiProduct(this.toTimes[i].derivative(),this.toTimes[0],tempArray);
    }
    Function finalDerivative = new MultiSum(temp1,temp2,derArray);
        return finalDerivative;

    }



    private Function[] removeItem(Function[] toRemove,int x, int y){
        Function[] removed = new Function[toRemove.length -2];
        int j =0;
        for (int i =0 ; i<toRemove.length ; i++){
            if(i != x && i != y){
                removed[j] = toRemove[i];
                j++;
            }
        }
        return removed;

    }
}
