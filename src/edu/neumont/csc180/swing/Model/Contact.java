package edu.neumont.csc180.swing.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {

    private String name;
    private String phone;
    private Date birthday;
    int id;

    public void setId(int id) {

    }

    public Contact() {
        this.name = "";
        this.phone = "";
        this.birthday = new Date(0);
    }

    PropertyChangeSupport changer = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener handler) {
        changer.addPropertyChangeListener(handler);
    }

    /**
     * Bound property for this Contact's name
     */
    public String getName() {
        return this.name;
    }

    public String getInfo() {
        return String.format("%s-%s", name, phone);
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            name = this.name;
            this.name = null;
        }
        String oldValue = this.name;
        this.name = name;
        changer.firePropertyChange("name", oldValue, name);
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        String oldValue = this.phone;
        this.phone = phone;
        changer.firePropertyChange("phone", oldValue, phone);
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        if (birthday.after(new Date())) throw new IllegalArgumentException("Birthdays must not be in the future!");

        Date oldValue = this.birthday;
        this.birthday = birthday;
        changer.firePropertyChange("birthday", oldValue, birthday);
    }


}
