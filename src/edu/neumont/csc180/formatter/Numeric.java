package edu.neumont.csc180.formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Numeric{

    //example Factory  see http://en.wikipedia.org/wiki/Factory_method_pattern
    public static NumberStringFormat getNumberStringExample() {
        return new NumberStringFormatExample();
    }



	public static void main(String[] args) throws ParseException{
		double val = 25.4567;
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMaximumFractionDigits(2);
		percent.setMinimumFractionDigits(2);
		System.out.println(percent.format(val));
		System.out.println(percent.format(.056));
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a percentage:");
		double input = percent.parse(scan.nextLine()).doubleValue();
		System.out.println(input);
		
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		currency.setGroupingUsed(false);
		System.out.println(currency.format(100033335.00444));


		
	}
}
