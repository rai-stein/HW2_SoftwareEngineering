package PACKAGE_NAME;public class Product extends PACKAGE_NAME.Function {
    private PACKAGE_NAME.Function[] product;

    public Product(PACKAGE_NAME.Function func1, PACKAGE_NAME.Function func2){

        this.product[0] = func1;
        this.product[1] = func2;
    }

    @Override
    public double valueAt(double x){
        return (product[0].valueAt(x)*product[1].valueAt(x));
    }

    @Override
    public String toString() {
        if (this.product[0].getClass() == PACKAGE_NAME.Constant.class){
            if (this.product[1].getClass() == PACKAGE_NAME.Constant.class){
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
