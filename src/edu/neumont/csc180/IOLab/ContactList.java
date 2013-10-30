package edu.neumont.csc180.IOLab;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/30/13
 * Time: 8:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class ContactList {
    private List<Contact> contacts;

    public ContactList(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(final Contact contact) {
        contacts.add(contact);
    }
}
