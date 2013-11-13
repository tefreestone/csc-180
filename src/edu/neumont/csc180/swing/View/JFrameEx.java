package edu.neumont.csc180.swing.View;

import edu.neumont.csc180.swing.Model.Contact;

import javax.swing.*;
import java.awt.*;


public class JFrameEx extends JFrame {


    public JFrameEx() {
        super("My Frame");

        addMenu();
        Contact c = new Contact();

        ContactInfo first = new ContactInfo();
        first.setContact(c);
        getContentPane().add(first, BorderLayout.NORTH);

        ContactInfo second = new ContactInfo();
        second.setContact(c);
        getContentPane().add(second, BorderLayout.SOUTH);

        pack();
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        this.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        JFrame main = new JFrameEx();
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
