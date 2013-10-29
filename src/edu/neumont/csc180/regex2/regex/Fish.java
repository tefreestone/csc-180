package edu.neumont.csc180.regex2.regex;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/29/13
 * Time: 7:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class Fish {
    private int count;
    private String group;
    private int start;


    public Fish(int count, String group, int start) {
        this.count = count;
        this.group = group;
        this.start = start;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "count=" + count +
                ", group='" + group + '\'' +
                ", start='" + start + '\'' +
                '}';
    }
}
