package edu.neumont.csc180.threads.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class PizzaEx {
    public static void main(String[] args) {
        Queue<Integer> pizzas = new LinkedList<>();
        Cooker cook = new Cooker(pizzas);
        cook.start();
        Driver d1 = new Driver(pizzas);
        d1.start();
        Driver d2 = new Driver(pizzas);
        d2.start();
        try {
            //cook.join();
            Thread.sleep(5000);
            cook.interrupt();
            synchronized (pizzas) {
                while (pizzas.size() > 0) {
                    pizzas.wait();
                }
            }
            d1.goHome();
            d2.goHome();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Driver extends Thread {
    Queue<Integer> pizzas;
    static int nextId = 1;
    int id = nextId++;
    boolean done = false;

    public Driver(Queue<Integer> pizzas) {
        this.pizzas = pizzas;
    }

    void goHome() {
        done = true;
    }

    Random r = new Random();

    @Override
    public void run() {
        while (!done) {
            try {
                Integer nextPizza = null;
                synchronized (pizzas) {
                    do {
                        nextPizza = pizzas.poll();
                        if (nextPizza == null) pizzas.wait();
                        else pizzas.notify();
                    } while (nextPizza == null);
                }
                Thread.sleep(r.nextInt(1000) + 1000);
                System.out.println(id + "delivered : " + nextPizza);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(id + " going home!");
    }
}

class Cooker extends Thread {
    Queue<Integer> pizzas;

    public Cooker(Queue<Integer> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(500);
                System.out.println("Cooked: " + i);
                synchronized (pizzas) {
                    pizzas.offer(i);
                    if (pizzas.size() == 1) pizzas.notify();
                    else pizzas.notifyAll();
                }
            } catch (InterruptedException e) {
                System.out.println("Terminating!");
                return;
            }
        }
        System.out.println("Pizzas cooked, going home :)");
    }
}
