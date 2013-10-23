package edu.neumont.csc180.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/21/13
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class EasyExample {
    public static void main(String[] args) {

        final String testString = "The rain in spain stays mainly in the plains.  However, it snows in the mountains and hails in the forest.";

        Pattern pattern = Pattern.compile("[rain]");
        Matcher matcher = pattern.matcher(testString);
        matcher.find();
        System.out.println("Start : " + matcher.start() + " end : " + matcher.end() + " found : " + matcher.find());

    }
}
