package edu.neumont.csc180.formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class StringFormatExample {



	public static void main(String[] args) throws ParseException{
		String year = "1997";
        String book = "Harry Potter and the Chamber of Secrets";
        String author = "J. K. Rowlings";

        System.out.printf("%25s%25s%25s%n",book,author,year);


		
	}
}
