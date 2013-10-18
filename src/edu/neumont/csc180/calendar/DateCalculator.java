package edu.neumont.csc180.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/18/13
 * Time: 7:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class DateCalculator {
    public static void main(String[] args){
        GregorianCalendar date1 = new GregorianCalendar(1993, 1, 5);
        GregorianCalendar date2 = new GregorianCalendar();

        date2.add(Calendar.YEAR, -date1.get(Calendar.YEAR));
        date2.add(Calendar.MONTH, -date1.get(Calendar.MONTH));
        date2.add(Calendar.DAY_OF_MONTH, -date1.get(Calendar.DAY_OF_MONTH) + 1);

        int years = date2.get(Calendar.YEAR);
        int months = date2.get(Calendar.MONTH);
        int days = date2.get(Calendar.DAY_OF_MONTH) - 1;

        System.out.println("days : " + days + " months : " + months + " years : " + years);
    }
}
