package edu.neumont.csc180.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchInFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(new File("/projects/csc-180/csc-180/Fish.html"));
        read.useDelimiter("$"); //Regex pattern for end of file.
        String text = read.next();
        read.close();

        Pattern regex = Pattern.compile("fish", Pattern.CASE_INSENSITIVE);
        Matcher search = regex.matcher(text);
        int count = 0;
        while (search.find()) {
            System.out.printf("Match %d: %s @ %d%n",
                    ++count, search.group(), search.start());
        }
    }
}
