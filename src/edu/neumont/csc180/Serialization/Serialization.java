package edu.neumont.csc180.Serialization;

import java.io.*;
import java.util.Date;

public class Serialization {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Jake", new Date());
        System.out.println(emp1);
        Date back = new Date(System.currentTimeMillis() - (1000L * 60 * 60 * 24 * 365 * 10));
        Employee emp2 = new Employee("OldGuy", back);
        System.out.println(emp2);
        try (FileOutputStream fileOut = new FileOutputStream("employees.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(emp1);
            objectOut.writeObject(emp2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Employee emp3 = null;
        Employee emp4 = null;
        try (FileInputStream fileIn = new FileInputStream("employees.ser");
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            emp3 = (Employee) objIn.readObject();
            emp4 = (Employee) objIn.readObject();
        } catch (IOException | ClassNotFoundException ex) {
        }
        System.out.println(emp3);
        System.out.println(emp4);
    }
}

class Not {
}

class Employee implements Serializable {
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", hireDate=" + hireDate + "]";
    }

    private String name;
    private Date hireDate;
    transient private Not isnt = new Not();
    transient private int id = nextId++;
    private static int nextId = 0;

    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {

//		this.name = (String)stream.readObject();
//		this.hireDate = (Date)stream.readObject();

        //this is the same as the commented lines;
        stream.defaultReadObject();
        this.id = stream.readInt();
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
//		stream.writeObject(this.name);
//		stream.writeObject(this.hireDate);

        //this is the same as the above lines;
        stream.defaultWriteObject();
        //write out a new ID
        stream.writeInt(nextId++);
    }

    Employee(String n, Date d) {
        this.name = n;
        this.hireDate = d;
    }
}
