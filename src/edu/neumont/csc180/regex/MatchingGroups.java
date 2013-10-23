package edu.neumont.csc180.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingGroups {
    public static void main(String[] args) {
        System.out.println("Enter the Regular Expression you would like to test:");
        Scanner in = new Scanner(System.in);
        String regex = in.nextLine();
        Pattern pattern = Pattern.compile(regex);
        String line;
        System.out.println("Enter a string to match against the pattern. Enter a blank line to quit.");
        while (!(line = in.nextLine()).isEmpty()) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                do {
                    System.out.println("Found match: " + matcher.group());
                    int lastGroup = matcher.groupCount();
                    if (lastGroup > 0) {
                        try {
                            System.out.println("Dept: " + matcher.group("Dep"));
                            System.out.println("Code: " + matcher.group("Code"));
                        } catch (Exception e) {
                        }
                        for (int i = 1; i <= lastGroup; i++) {
                            System.out.printf("\t%d)%s%n", i, matcher.group(i));
                        }
                    }
                } while (matcher.find());
            } else {
                System.out.println("No matches found.");
            }
            System.out.println("Enter a string to match against the pattern. Enter a blank line to quit.");
        }
        System.out.println("Goodbye.");
    }
}
