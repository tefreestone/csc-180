package edu.neumont.csc180.Generics;

public class Holder<T> {

    private T holding;

    public T getHolding() {
        return this.holding;
    }

    public Holder(T holding) {
        this.holding = holding;
    }

    public void method(int param) {
        System.out.println(param);
        param++;
    }


    public static void main(String[] args) {
        Holder<Integer> holdInt = new Holder<>(10);
        int t = holdInt.getHolding();
        System.out.println(t);

        Holder<String> holdString = new Holder<>("Words");
        String s = holdString.getHolding();

        //can't do this - the type argument must match!
        //Holder<String> holdString = new Holder<>(new Date());
    }
}
