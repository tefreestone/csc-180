package edu.neumont.csc180.regex2.regex;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchInFile {
    public static void main(String[] args) throws FileNotFoundException {
        ReadFishFile fishFile = new ReadFishFile("/projects/csc-180/csc-180/Fish.html");

        Pattern regex = Pattern.compile("http(s)", Pattern.CASE_INSENSITIVE);
        Matcher search = regex.matcher(fishFile.getFileText());
        int count = 0;
        while (search.find()) {
            Fish fish = new Fish(++count, search.group(), search.start());
//            FishUrl fishUrl = new FishUrl(search);
            System.out.println(fish);
            // Print url instead
        }
    }
}
