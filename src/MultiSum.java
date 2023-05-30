public class MultiSum extends Function {
    public int numFunc;
    public Function[] toAdd;

    public MultiSum(Function ... functions){
        this.numFunc = functions.length;
        this.toAdd = functions;
    }

    @Override
    public double valueAt(double x) {
        double toReturn = 0;
        for(int i = 0; i < this.numFunc; i++){
            toReturn += toAdd[i].valueAt(x);
        }
        return toReturn;
    }

    @Override
    public String toString() {
        String toReturn = "(";



        toReturn += ")";
        return toReturn;
    }

    @Override
    public Function derivative() {


    }






}
