package edu.neumont.csc180.MVC.viewGui;

import edu.neumont.csc180.MVC.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;


public class JFramEx extends JFrame {
    public JFramEx() {

        Contact tom = new Contact();
        Contact santa = new Contact();

        this.getContentPane().add(new ContactInfo(tom), BorderLayout.NORTH);
        this.getContentPane().add(new ContactInfo(santa), BorderLayout.SOUTH);

        tom.setName("Tom Freestone");
        tom.setBirthday(new Date(System.currentTimeMillis() - (1000l * 60 * 60 * 24)));
        tom.setPhone("123-456-6789");

        santa.setName("Santa Claus");
        Calendar santaBirthday = Calendar.getInstance();
        santa.setBirthday(new Date(santaBirthday.get(Calendar.YEAR) - 100));
        santa.setPhone("N/A");

        pack();
    }

    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            //Use default look and feel
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame main = new JFramEx();
                main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                main.setVisible(true);
            }
        });
    }

}
