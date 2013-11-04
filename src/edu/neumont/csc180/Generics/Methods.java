package edu.neumont.csc180.Generics;

import java.util.ArrayList;
import java.util.List;

//T – used to denote type
//        E – used to denote element
//        K – keys
//        V - values
//        N – for numbers


//        Read more: http://javarevisited.blogspot.com/2011/09/generics-java-example-tutorial.html#ixzz2jgOe77Et

public class Methods {
    public static <T> void addToList(List<T> list, T toAdd) {
        list.add(toAdd);
        T t = null;
        List<T> list2 = new ArrayList<T>();
    }

    public static <V> List<V> test() {
        ArrayList<V> vs = new ArrayList<V>();
        return vs;
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();
        addToList(intList, 10);

        List<String> stringList = new ArrayList<String>();
        addToList(stringList, "Hello");

        List<Integer> ints = test();
    }
}
