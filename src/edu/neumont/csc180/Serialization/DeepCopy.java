package edu.neumont.csc180.Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeepCopy {
    public static void main(String[] args) {
        Storage s = new Storage();
        s.addData(new Data("Bob"));
        s.addData(new Data("Jake"));
        s.addData(new Data("Andy"));

        List<Data> data = s.getData();
        System.out.println(data);

        data.get(0).setName(null);
        data.get(1).setId(-5);
        data.add(0, new Data("Out of order!"));
        System.out.println(s.getData());
    }
}

class Storage {
    List<Data> data = new ArrayList<>();

    public void addData(Data d) {
        if (d.getName() == null || d.getId() < 0) throw new IllegalArgumentException();
        this.data.add(d);
        Collections.sort(data);
    }

    public List<Data> getData() {
        return this.deepCopy();
    }

    private List<Data> deepCopy() {

        ByteArrayOutputStream storage = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(storage)) {
            out.writeObject(this.data);
        } catch (IOException e) {
            //virtually impossible for byte array to fail, no recovery.
            throw new RuntimeException(e);
        }
        try (ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(storage.toByteArray()))) {
            List<Data> copy = (List<Data>) in.readObject(); //compiler warning because this is inherantly unsafe!
            return copy;
        } catch (IOException | ClassNotFoundException e) {
            //no recovery here either
            throw new RuntimeException(e);
        }
    }
}

class Data implements Serializable, Comparable<Data> {
    @Override
    public String toString() {
        return String.format("%s:%d", this.name, this.id);
    }

    static int nextId = 0;
    private int id = nextId++;
    private String name;

    public Data(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Data d) {
        return this.name.compareTo(d.name);
    }
}
