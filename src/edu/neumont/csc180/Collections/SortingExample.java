package edu.neumont.csc180.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 11/1/13
 * Time: 7:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class SortingExample {

    private List<String> fruits;

    public void pieceOJunk() {
        String[] myStringArray = new String[3];
        String[] myStringArray1 = {"a", "b", "c"};
        String[] myStringArray2 = new String[]{"a", "b", "c"};

        for (int i = 0; i >= myStringArray1.length - 1; i++) {
            System.out.println(myStringArray1[i]);
        }
    }


    public void sortFruit() {
        fruits = new ArrayList<String>();

        fruits.add("Pineapple");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");

        Collections.sort(fruits);

        int i = 0;
        for (String temp : fruits) {
            System.out.println("fruits " + ++i + " : " + temp);
        }
    }

    public void sortUsingComparator() {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Pineapple", "Pineapple description", 70));
        fruits.add(new Fruit("Apple", "Apple description", 100));
        fruits.add(new Fruit("Orange", "Orange description", 80));
        fruits.add(new Fruit("Banana", "Banana description", 90));
        Collections.sort(fruits);

        int i = 0;
        for (Fruit temp : fruits) {
            System.out.println("fruits " + ++i + " : " + temp);
        }
    }

    public void sortUsingComparatorByName() {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Pineapple", "Pineapple description", 70));
        fruits.add(new Fruit("Apple", "Apple description", 100));
        fruits.add(new Fruit("Orange", "Orange description", 80));
        fruits.add(new Fruit("Banana", "Banana description", 90));
        Collections.sort(fruits, Fruit.FruitNameComparator);

        int i = 0;
        for (Fruit temp : fruits) {
            System.out.println("fruits " + ++i + " : " + temp);
        }
    }
}
