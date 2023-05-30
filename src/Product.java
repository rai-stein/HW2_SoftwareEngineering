
public class Product extends MultiProduct {
    private Function[] product;

    public Product(Function func1, Function func2){
        this.product[0] = func1;
        this.product[1] = func2;
    }

    @Override
    public double valueAt(double x){
        return (product[0].valueAt(x)*product[1].valueAt(x));
    }

    @Override
    public String toString() {
        if (this.product[0].getClass() == Constant.class){
            if (this.product[1].getClass() == Constant.class){
                double temp =  this.product[0].valueAt(0)*this.product[1].valueAt(0);
                return Double.toString(temp);
            }
            return (Double.toString(this.product[0].valueAt(0))+this.product[1].toString());
        }
        else if (this.product[1].getClass() == Comparable.class){
            return (Double.toString(this.product[1].valueAt(0))+this.product[0].toString());
        }
        return "("+this.product[0].toString()+this.product[1].toString()+")";
    }
}
