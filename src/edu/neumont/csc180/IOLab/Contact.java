package edu.neumont.csc180.IOLab;

/**
 * Created with IntelliJ IDEA.
 * User: tefreestone
 * Date: 10/30/13
 * Time: 8:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class Contact {
    private String Name;
    private String email;
    private String phone;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
