package edu.neumont.csc180.Collections;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 11/1/13
 * Time: 7:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class CollectionsExample {
    public void asList() {
        List<String> stringList = new ArrayList<>();
        stringList = new LinkedList<>();

    }

    public void asSet() {
        Set<String> stringSet = new HashSet<>();
    }

    public void asQueue() {
        Queue queue = new LinkedList();
    }

    public void asMap() {
        Map<Integer, String> coolMap = new HashMap<>();
    }
}
