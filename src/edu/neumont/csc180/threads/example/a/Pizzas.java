package edu.neumont.csc180.threads.example.a;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Pizzas {
    public static void main(String[] args) {
        Queue<String> pizzas = new LinkedList<>();
        Pizzaria cooker = new Pizzaria(pizzas);
        cooker.start();
        Driver d1 = new Driver(pizzas);
        Driver d2 = new Driver(pizzas);
        Driver d3 = new Driver(pizzas);
        Driver d4 = new Driver(pizzas);
        Driver d5 = new Driver(pizzas);
        d1.start();
        d2.start();
        d3.start();
        d4.start();
        d5.start();
        try {
            cooker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d1.noMore();
        d2.noMore();
        d3.noMore();
        d4.noMore();
        d5.noMore();
    }
}

class Driver extends Thread {
    Random r = new Random();
    Queue<String> pizzas;
    static int nextId = 1;
    int id = nextId++;
    boolean go = true;

    void noMore() {
        go = false;
    }

    public Driver(Queue<String> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public void run() {
        while (go) {
            String nextPizza;
            try {
                synchronized (pizzas) {
                    while (pizzas.size() == 0) {
                        try {
                            //Thread.sleep(100); //BAD in a sync block
                            //System.out.println(id+" waiting");
                            pizzas.wait();
                            if (pizzas.size() == 0) pizzas.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (!go) return;
                    }
                    nextPizza = pizzas.poll();
                }
                Thread.sleep(r.nextInt(2000));
                System.out.println(id + " delivered " + nextPizza);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Pizzaria extends Thread {
    Queue<String> pizzas;
    boolean cooking = true;
    static final String[] TYPES = new String[]{"Pepperoni", "Sausage", "Cheese", "Hawaiian",
            "Supreme", "Bacon"};

    public Pizzaria(Queue<String> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
                String pizza = TYPES[i % TYPES.length] + i;
                System.out.println("Cooked: " + pizza);
                synchronized (pizzas) {
                    pizzas.offer(pizza);
                    pizzas.notifyAll();
                }//notify really happends here!
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cooking = false;

    }
}
