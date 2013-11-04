package edu.neumont.csc180.Generics;

import java.util.ArrayList;


public class WildCard {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        ints.add(30);

    }

    static void printValues(ArrayList<?> list) {
//		list.get
//		list.add("bob");
//		list.add(1);
        int count = list.size();
        for (int i = 0; i < count; i++) {
            Object o = list.get(i);
            System.out.println(o);
        }
    }

    static double SumNums(ArrayList<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        //can't do this!
        //list.add(10.5);
        return sum;
    }
}

