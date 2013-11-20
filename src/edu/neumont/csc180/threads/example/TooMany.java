package edu.neumont.csc180.threads.example;

public class TooMany extends Thread {
    static int next = 1;
    int id = next++;

    @Override
    public void run() {
        long l = 0;
        while (true) System.out.println(id + ": " + l++);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            TooMany tm = new TooMany();
            tm.start();
        }
    }
}
