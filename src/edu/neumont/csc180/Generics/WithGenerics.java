package edu.neumont.csc180.Generics;

import java.util.ArrayList;


public class WithGenerics {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();

        strings.add("Hello");
        strings.add("class");

        //can't do this - only Strings!
//		strings.add(1);
//		strings.add(new Date());

        String s = strings.get(0);
        System.out.println(s);
    }
}
