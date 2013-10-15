package edu.neumont.csc180.strings;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/15/13
 * Time: 7:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringExample {

    public void exampleOfString() {
        String stuff = "Hello World";
        StringBuffer someOtherStuff = new StringBuffer("Hello World");

        stuff = stuff + " more stuff";
        someOtherStuff.append(" more stuff");


    }
}
