package edu.neumont.csc180.swing.View;

import edu.neumont.csc180.swing.Model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;


public class ContactInfo extends JPanel {
    private JLabel nameLabel, phoneLabel, birthdayLabel;
    private JTextField nameText, phoneText, birthdayText;
    private Contact contact;

    public void setContact(Contact c) {
        this.contact = c;
        c.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateContact();
            }
        });
        updateContact();
    }

    private static final DateFormat DATEFORMAT =
            DateFormat.getDateInstance(DateFormat.MEDIUM);

    private void updateContact() {
        this.getNameText().setText(this.contact.getName());
        this.getPhoneText().setText(this.contact.getPhone());
        this.getBirthdayText().setText(DATEFORMAT.format(this.contact.getBirthday()));
    }

    public JTextField getNameText() {
        if (this.nameText == null) {
            this.nameText = new JTextField(15);
            this.nameText.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    contact.setName(nameText.getText());
                }
            });
        }
        return this.nameText;
    }

    public JTextField getPhoneText() {
        if (this.phoneText == null) {
            this.phoneText = new JTextField(15);
            this.phoneText.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    contact.setPhone(phoneText.getText());
                }
            });
        }
        return this.phoneText;
    }

    public JTextField getBirthdayText() {
        if (this.birthdayText == null) {
            this.birthdayText = new JTextField(15);
            this.birthdayText.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //parse the date
                    } catch (Exception ex) {
                        //roll back
                    }
                }
            });
        }
        return this.birthdayText;
    }

    public ContactInfo() {
        this.setLayout(new GridLayout(0, 2));
        this.nameLabel = new JLabel("Name");
        this.phoneLabel = new JLabel("Phone");
        this.birthdayLabel = new JLabel("Birthday");
        this.add(nameLabel);
        this.add(getNameText());
        this.add(phoneLabel);
        this.add(getPhoneText());
        this.add(birthdayLabel);
        this.add(getBirthdayText());
    }
}
