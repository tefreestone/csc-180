package edu.neumont.csc180.IOLab;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/30/13
 * Time: 8:05 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ContactIO {
    public ContactList getAllContacts();

    public ContactList writeAllContacts();

    public String getFileName();

    public String setFileName();
}
