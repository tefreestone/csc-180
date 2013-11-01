package edu.neumont.csc180.IO;

import java.io.DataOutputStream;
import java.io.IOException;

public class Contact {
    private String name;
    private int id;

    public Contact(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void write(DataOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeInt(id);
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", name=" + name + "]";
    }
}
