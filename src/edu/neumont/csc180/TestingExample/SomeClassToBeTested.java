package edu.neumont.csc180.TestingExample;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/24/13
 * Time: 7:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class SomeClassToBeTested implements SomeClass {

    private int someNumber;
    private String joke;

    @Override
    public String tellJoke(final String setup) {
        if (setup != null && setup.equals("knock knock")) {
            return "whose there?";
        } else
            throw new IllegalArgumentException("jokes aren't funny without a setup");
    }

    @Override
    public int divideByTwo(final int someNumber) {
        if (someNumber > 0) {
            this.someNumber = someNumber / 2;
            return getSomeNumber();
        } else
            throw new IllegalArgumentException("Number must be positive");
    }

    public int getSomeNumber() {
        return someNumber;
    }

}
