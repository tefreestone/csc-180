package edu.neumont.csc180.Generics;

class Car implements Comparable<Car> {
    int passengers;

    public Car(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public int compareTo(Car other) {
        return this.passengers - other.passengers;
    }

}

public class Comparison {
    public static void main(String[] args) {
    }
}
