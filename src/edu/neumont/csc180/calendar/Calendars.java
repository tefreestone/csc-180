package edu.neumont.csc180.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Calendars{



	public static void main(String[] args){
		GregorianCalendar cal = new GregorianCalendar();
		DateFormat custom = new SimpleDateFormat("MM-d-yyyy");
		System.out.println(custom.format(cal.getTime()));

		cal.add(Calendar.MONTH, 1);
		System.out.println(custom.format(cal.getTime()));
		
		System.out.println(cal.after(new GregorianCalendar()));
		
		GregorianCalendar lastDay = new GregorianCalendar(2013, GregorianCalendar.JANUARY, 31);
		int day = lastDay.get(Calendar.DAY_OF_MONTH);
		lastDay.add(Calendar.DAY_OF_MONTH, 3) ;
		System.out.println(lastDay.getTime());
	}
}
