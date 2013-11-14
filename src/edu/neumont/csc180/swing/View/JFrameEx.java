package edu.neumont.csc180.swing.View;

import edu.neumont.csc180.swing.Model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class JFrameEx extends JFrame implements ActionListener {
    private JButton jButton;
    private Random random;

    public JFrameEx() {

        super("My Frame");
        random = new Random();
        addMenu();
        Contact c = new Contact();

        ContactInfo first = new ContactInfo();
        first.setContact(c);
        getContentPane().add(first, BorderLayout.NORTH);

        ContactInfo second = new ContactInfo();
        second.setContact(c);
        getContentPane().add(second, BorderLayout.SOUTH);

        jButton = new JButton("Crazy button");
        jButton.addActionListener(this);
        getContentPane().add(jButton, BorderLayout.EAST);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        int someColor = random.nextInt(10000000);
        System.out.println("someColor : " + someColor);
        jButton.setBackground(new Color(someColor));
        jButton.revalidate();
        jButton.repaint();
    }
}
