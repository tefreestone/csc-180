package edu.neumont.csc180.Generics;

import java.util.ArrayList;
import java.util.Date;


public class NoGenerics {
    public static void main(String[] args) {
        ArrayList ar = new ArrayList();
        ar.add(10);
        ar.add(new Date());
        ar.add("Words");

        int value = (int) ar.get(1);
        System.out.println(value);
        value++;
    }
}
