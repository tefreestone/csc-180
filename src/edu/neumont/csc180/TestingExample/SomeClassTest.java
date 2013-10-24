package edu.neumont.csc180.TestingExample;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/24/13
 * Time: 7:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class SomeClassTest {

    private static final String JOKE_TEXT = "whose there?";
    private String funnyJoke;
    private int aNumber;
    private SomeClass someClass;

    @Before
    public void setUp() throws Exception {
        this.funnyJoke = "knock, knock";
        int aNumber = 39;
        someClass = new SomeClassToBeTested();
    }

    @Test
    public void testTellJoke() throws Exception {

        //Start with pre-conditions not null and not equal to knock, knock
        try {
            someClass.tellJoke(null);
            Assert.assertFalse(true);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        try {
            someClass.tellJoke("junk");
            Assert.assertFalse(true);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }

        String result = someClass.tellJoke("knock knock");
        // check to make not null
        Assert.assertNotNull(result);
        // check to see if output is write
        // checking post-conditions
        Assert.assertEquals(JOKE_TEXT, result);


    }

    @Test
    public void testDivideByTwo() throws Exception {
        //Start with pre-conditions < 0

        try {
            someClass.divideByTwo(-100);
            Assert.assertFalse(true);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        // boundary case -> mostly likely to have errors
        try {
            someClass.divideByTwo(0);
            Assert.assertFalse(true);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }

        // Post-Conditions
        int whatIExpect = 4 / 2;
        Assert.assertEquals(whatIExpect, someClass.divideByTwo(4));

        Assert.assertEquals(whatIExpect, someClass.getSomeNumber());
    }
}
