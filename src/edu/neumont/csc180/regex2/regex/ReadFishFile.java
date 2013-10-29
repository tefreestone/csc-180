package edu.neumont.csc180.regex2.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/29/13
 * Time: 7:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReadFishFile {
    private String fileName;

    public ReadFishFile(final String fileName) {
        this.fileName = fileName;
    }

    public String getFileText() throws FileNotFoundException {
        if (fileName != null) {
            Scanner read = new Scanner(new File(fileName));
            read.useDelimiter("$"); //Regex pattern for end of file.
            String text = read.next();
            read.close();

            return text;
        } else
            throw new IllegalAccessError("filename == null");
    }
}
