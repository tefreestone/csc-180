package edu.neumont.csc180.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 11/1/13
 * Time: 7:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class FruitMain {
    public static void main(String[] args) {
        SortingExample sortingExample = new SortingExample();
        System.out.println("As a String:");
        sortingExample.sortFruit();
        System.out.println("By Quantity:");
        sortingExample.sortUsingComparator();
        System.out.println("By Name:");
        sortingExample.sortUsingComparatorByName();
    }
}
