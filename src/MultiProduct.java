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

        String toReturn ="(";
        if (toTimes[0].getClass()== Constant.class && toTimes[0].valueAt(0) == -1){
            toReturn+="-";
        }
        else {
            toReturn += toTimes[0].toString()+" * ";
        }


        for (int i = 1; i < this.toTimes.length-1; i++){
            if (this.toTimes[i].getClass() == Constant.class){
                if(this.toTimes[i].valueAt(0) == 1) continue;
                else if(this.toTimes[i].valueAt(0) == -1) toReturn += "-";
                else {
                    toReturn +=   this.toTimes[i].toString()+" * ";

                }
            }
            else {
                toReturn +=   this.toTimes[i].toString()+" * ";
            }
        }
        toReturn += this.toTimes[toTimes.length-1] +")";
        return toReturn.toString();
    }

    @Override
    public Function derivative() {

        Function[] tempArray  = removeItem(this.toTimes,0,1);
        Function temp1 = new MultiProduct(this.toTimes[0].derivative(),this.toTimes[1],tempArray );
        Function temp2 = new MultiProduct(this.toTimes[1].derivative(),this.toTimes[0],tempArray);
        if (this.toTimes.length == 2 ){
            return new Sum(temp1,temp2);
        }
        Function[] derArray = new Function[numFunc];
        for (int i = 2 ; i<this.numFunc+2; i++){
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
