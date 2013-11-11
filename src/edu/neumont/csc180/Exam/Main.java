package edu.neumont.csc180.Exam;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 11/9/13
 * Time: 10:08 PM
 * To change this template use File | Settings | File Templates.
 */


public class Main {

    public static void question5(String someString) {
        if (someString != null) {
            try {
                throw new IllegalStateException();
            } catch (Exception e) {

            }
        } else
            throw new IllegalArgumentException("someString == null");
    }

    public static void question4() {
        String text = "How are you, Jake? I'm fine.";
        String[] tokens = text.split("[?,\\s]+"); //splits based on a regular expression
        for (String s : tokens) System.out.println(s);
    }


    public static void main(String[] args) {
        Main.question4();
    }
}
