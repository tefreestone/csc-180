package edu.neumont.csc180.Exam;

import java.io.*;

public class Serial implements Serializable {
    private int i;
    public int j;
    transient int k;

    public Serial() {
        i = 1;
        j = 2;
        k = 3;
    }

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("file.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(new Serial());
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("file.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Serial s = (Serial) ois.readObject();
        ois.close();

        System.out.print(s.i);
        System.out.print(s.j);
        System.out.println(s.k);
    }
}
