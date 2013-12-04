

package edu.neumont.csc180.JAXB.nongenerated;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Student {

    protected String email;
    protected String name;
    protected String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

}
