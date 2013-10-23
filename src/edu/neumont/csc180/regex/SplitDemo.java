package edu.neumont.csc180.regex;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/23/13
 * Time: 7:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(input.split("!!")));

        input = "This is an usual use of exclamation points";
        System.out.println(Arrays.toString(input.split("\\s+")));

    }
}
