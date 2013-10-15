package edu.neumont.csc180.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/15/13
 * Time: 7:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class SomeClassWithProblems {

    public void someTryMethod(String somePotentialProblem) throws IllegalArgumentException {
        somePotentialProblem = "stuff";
        try {

        } catch (IllegalArgumentException exeception) {
            return;
        }  catch (OutOfMemoryError e) {

        }  finally {

        }

    }

    public void someThrowMethod(final String someOtherProblem) {
        if(someOtherProblem != null) {

        }   else
            throw new IllegalArgumentException("someotherproblem == null");


    }
}
