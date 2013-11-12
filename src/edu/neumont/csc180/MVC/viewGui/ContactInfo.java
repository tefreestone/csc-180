package edu.neumont.csc180.MVC.viewGui;

import edu.neumont.csc180.MVC.model.Contact;

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
    private final DateFormat dateformat = DateFormat.getDateInstance(DateFormat.MEDIUM);

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
        }
        return this.phoneText;
    }

    public JTextField getBirthdayText() {
        if (this.birthdayText == null) {
            this.birthdayText = new JTextField(15);
        }
        return this.birthdayText;
    }


    private void updateContact(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "name":
                this.getNameText().setText((String) evt.getNewValue());
                break;
            case "phone":
                this.getPhoneText().setText((String) evt.getNewValue());
                break;
            case "birthday":
                this.getBirthdayText().setText(dateformat.format(evt.getNewValue()));
                break;
            default:
                System.err.println("Unknown property to update?");
        }

    }


    public ContactInfo(Contact contact) {
        this.contact = contact;
        if (contact != null) {
            contact.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    updateContact(evt);
                }
            });
        }
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
