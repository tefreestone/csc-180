package edu.neumont.csc180.Serialization;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/31/13
 * Time: 7:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class SomeClass implements Serializable {
    private String stuff;

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }
}
