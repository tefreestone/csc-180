package edu.neumont.csc180.MVC.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {
    private String name;
    private String phone;
    private Date birthday;

    public Contact() {
        this.name = "";
        this.phone = "";
        this.birthday = new Date();
    }

    PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener handler) {
        support.addPropertyChangeListener(handler);
    }

    public void removePropertyChangeListener(PropertyChangeListener handler) {
        support.removePropertyChangeListener(handler);
    }

    public Contact(String name, String phone, Date birthday) {
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
    }

    /**
     * Getter for bound property "name"
     *
     * @return the name of this contact
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        support.firePropertyChange("name", oldValue, this.name);
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        String oldValue = this.phone;
        this.phone = phone;
        support.firePropertyChange("phone", oldValue, this.phone);
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        Date oldValue = this.birthday;
        this.birthday = birthday;
        support.firePropertyChange("birthday", oldValue, this.birthday);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "birthday=" + birthday +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
