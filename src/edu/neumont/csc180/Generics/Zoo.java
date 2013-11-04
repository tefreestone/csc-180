package edu.neumont.csc180.Generics;

import java.util.Arrays;
import java.util.Iterator;

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void introduce(Animal another) {
        System.out.printf("%s meets %s.%n", this.name, another.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Deer extends Animal {
    public Deer(String name) {
        super(name);
    }
}

class Bear extends Animal {
    public Bear(String name) {
        super(name);
    }

    @Override
    public void introduce(Animal another) {
        super.introduce(another);
        if (!(another instanceof Bear)) {
            System.out.printf("%s eating %s%n.", this.name, another.getName());
            another.name = "Food!";
        }
    }
}

class Cage<A extends Animal> implements Iterable<A> {
    private Animal[] animals;
    private int capacity;
    private int occupancy;

    public Cage(int capacity) {
        this.capacity = capacity;
        animals = new Animal[capacity];
    }

    public boolean add(A newAnimal) {
        if (occupancy < capacity) {
            for (int i = 0; i < occupancy; i++) {
                Animal resident = animals[i];
                resident.introduce(newAnimal);
            }
            animals[occupancy++] = newAnimal;
            return true;
        }
        return false;
    }

    public A getAnimal(int i) {
        return (A) animals[i];
    }

    @Override
    public String toString() {

        String firstClass = (capacity > 0) ? animals[0].getClass().getName() : "?";
        return String.format("%s Cage%s%n", firstClass, Arrays.toString(animals));
    }

    @Override
    public Iterator<A> iterator() {

        return new Iterator<A>() {
            int next = 0;

            @Override
            public boolean hasNext() {
                return next < occupancy;
            }

            @Override
            public A next() {
                return (A) animals[next++];
            }

            @Override
            public void remove() {
                animals[--next] = null;

            }

        };
    }
}

public class Zoo {
    public static void main(String[] args) {
        Cage<Bear> cage1 = new Cage<>(2);
        cage1.add(new Bear("Yogi"));
        cage1.add(new Bear("Smokey"));
        //cage1.add(new Deer("Faun"));
        System.out.println(cage1);
        Bear b = cage1.getAnimal(0);

        Cage<Deer> cage2 = new Cage<>(3);
        cage2.add(new Deer("Bambi"));
        System.out.println(cage2);
        Deer d = cage2.getAnimal(0);

        Cage any = new Cage(3);
        any.add(new Bear("Grizzly"));
        any.add(new Deer("Venison"));
        Animal a = any.getAnimal(0);
        System.out.println(any);
    }
}
