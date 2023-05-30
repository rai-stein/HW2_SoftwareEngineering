public class Negation extends Product {
    public Negation(Function func){
        super(new Constant(-1), func);
    }
}
