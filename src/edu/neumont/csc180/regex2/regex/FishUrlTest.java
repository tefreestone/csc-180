package edu.neumont.csc180.regex2.regex;

import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/29/13
 * Time: 8:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class FishUrlTest {
    FishUrl fishUrl;

    @Before
    public void setUp() {
        FishUrl testFishUrl = new FishUrl("This is a url http://www.cnn.com/somethingShouldBeHere");
    }

    @Test
    public void testGetUrl() throws Exception {

    }

    @Test
    public void testGetDomain() throws Exception {
//        String result = testFishUrl.getUrl();
//        Assert.assertEquals("www.cnn.com", results);
    }

    @Test
    public void testGetPath() throws Exception {
//        String result = testGetUrl();
//        Assert.assertEquals("somethingShouldBeHere", result);
    }
}
