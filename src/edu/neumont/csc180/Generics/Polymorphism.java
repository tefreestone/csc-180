package edu.neumont.csc180.Generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Polymorphism {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.add("Bob");
        String value = strings.get(1);


        String s = new String();
        Object o = s;

        List<Object> objects = new ArrayList<>();
        objects.add(10);
        objects.add(new Date());

        //cannot do!!
        //	objects = strings;
        objects.add(50);
        String another = strings.get(1);

    }
}
