package edu.neumont.csc180.MVC.viewTui;

import edu.neumont.csc180.MVC.model.Contact;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactInfo {

    private List<Contact> contacts;
    private final DateFormat dateformat = DateFormat.getDateInstance(DateFormat.MEDIUM);

    public ContactInfo() {
        contacts = new ArrayList<>();
    }

    public void doMenu() {
        Scanner in = new Scanner(System.in);
        // print menu
        for (int i = 1; i <= 5; i++)
            System.out.println(i + ". Menu item #" + i);
        System.out.println("0. Quit");
        // handle user commands
        boolean quit = false;
        int menuItem;
        do {
            System.out.print("Choose menu item: ");
            menuItem = in.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("You've chosen item #1");
                    for (Contact c : contacts) {
                        System.out.println(c);
                    }
                    break;
                case 2:
                    System.out.println("You've chosen item #2");
                    // do something...
                    break;
                case 3:
                    System.out.println("You've chosen item #3");
                    // do something...
                    break;
                case 4:
                    System.out.println("You've chosen item #4");
                    // do something...
                    break;
                case 5:
                    System.out.println("You've chosen item #5");
                    // do something...
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!quit);
        System.out.println("Bye-bye!");
    }

    public void add(Contact c) {
        if (c != null) {
            contacts.add(c);
        } else
            throw new IllegalArgumentException("c = null");
    }
}

