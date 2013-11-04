package edu.neumont.csc180.Generics;

public class HoldNumber<Num extends Number> {

    Num n;

    void useNum() {
        System.out.println(n.doubleValue() * 2);
    }

    public static void main(String[] args) {

        HoldNumber<Integer> ints = new HoldNumber<>();
        ints.n = 10;

        HoldNumber<Double> doubles = new HoldNumber<>();
        doubles.n = 50.5;


    }
}
