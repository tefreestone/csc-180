package edu.neumont.csc180.MVC.viewTui;

import edu.neumont.csc180.MVC.model.Contact;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;


public class ContactMain extends JFrame {

    public static void main(String[] args) {
        Contact tom = new Contact();
        Contact santa = new Contact();


        tom.setName("Tom Freestone");
        tom.setBirthday(new Date(System.currentTimeMillis() - (1000l * 60 * 60 * 24)));
        tom.setPhone("123-456-6789");

        santa.setName("Santa Claus");
        Calendar santaBirthday = Calendar.getInstance();

        santa.setBirthday(new Date(santaBirthday.get(Calendar.YEAR) - 100));
        santa.setPhone("N/A");
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.add(tom);
        contactInfo.add(santa);

        contactInfo.doMenu();
    }

}
