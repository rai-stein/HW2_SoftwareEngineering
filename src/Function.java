public abstract class Function {
    static public double kavua = Math.pow(10, -5);
    public abstract double valueAt(double x);
    public abstract String toString();
    public abstract Function derivative();
    public double bisectionMethod(double a, double b, double epsilon){
        double left = a;
        double right = b;
        while(right-left > epsilon){
            double mid = (left + right)/2;
            if(this.valueAt(left) * this.valueAt(mid) > 0){
                left = mid;
            } else{
                right = mid;
            }
        }
        return (left + right)/2;
    }
    public double bisectionMethod(double a, double b){
        double left = a;
        double right = b;
        while(right-left > kavua){
            double mid = (left + right)/2;
            if(this.valueAt(left) * this.valueAt(mid) > 0){
                left = mid;
            } else{
                right = mid;
            }
        }
        return (left + right)/2;
    }
    public double newtonRaphsonMethod(double a, double epsilon){
        double xk = a;
        double xk1 = a - (this.valueAt(xk)/this.derivative().valueAt(xk));
        while(this.valueAt(xk) >= epsilon){
            xk = xk1;
            xk1 = a - (this.valueAt(xk)/this.derivative().valueAt(xk));
        }
        return xk;
    }
    public double newtonRaphsonMethod(double a){
        double xk = a;
        double xk1 = a - (this.valueAt(xk)/this.derivative().valueAt(xk));
        while(this.valueAt(xk) >= kavua){
            xk = xk1;
            xk1 = a - (this.valueAt(xk)/this.derivative().valueAt(xk));
        }
        return xk;
    }
    public Function taylorPolynomial(int n){
        Function[] tayArray = new Function[n];
        Function tay1 = new Constant(this.valueAt(0));
        Function tay2 = new Product(new Constant(this.derivative().valueAt(0)),new simpleX());
        if(n == 0){
            return this;
        }
        if(this instanceof Constant){
            return this;
        }
        if (n == 1){
            return new Sum(tay1, tay2);
        }
        Function tempDerivative = this.derivative();
        double factorial = 1;
        int j =0;
        for (int i = 2; i<= n ; i++){
            tempDerivative = tempDerivative.derivative();
            factorial *= i;
            tayArray[j] = new Quotient(
                    new Product(
                            new Constant(tempDerivative.valueAt(0)),
                                    new Power(
                                            new simpleX(),i
                                    )
                            ),new Constant(factorial)
                    );
            j++;
        }
        return new MultiSum(tay1, tay2, tayArray);
    }
}

