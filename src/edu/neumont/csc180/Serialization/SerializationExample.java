package edu.neumont.csc180.Serialization;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/31/13
 * Time: 7:36 AM
 * To change this template use File | Settings | File Templates.
 */

public class SerializationExample implements Serializable {

    private String someProperty;
    private String somethingElse;
    private String pieceOJunk;

    private transient String password;

    private SomeClass someClass;

    public SerializationExample() {
        someClass = new SomeClass();
    }

    public void someMethod() {
        String stuff = new String("Happy Spook Day!");

        stuff = null;
        System.gc();
    }
    /**
     * <SerializationExample>
     *     <someProperty>
     *
     *     </someProperty>
     *
     * </SerializationExample>
     */
}
