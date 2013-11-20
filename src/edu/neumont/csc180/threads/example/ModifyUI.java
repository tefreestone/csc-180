package edu.neumont.csc180.threads.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyUI extends JFrame {
    private JPanel box;

    public ModifyUI() {
        super("Modify Me");
        box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        this.setContentPane(new JScrollPane(box));
        JButton button = new JButton("Add");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addField();
                box.revalidate();
                //box.repaint(); //does not work
            }
        });
        box.add(button);
        addField();
        this.setSize(400, 200);
    }

    private void addField() {
        JTextField field = new JTextField(20);
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, (int) field.getPreferredSize().getHeight()));
        box.add(field);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ui = new ModifyUI();
                ui.setLocationRelativeTo(null);
                ui.setVisible(true);
                ui.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
    }
}
