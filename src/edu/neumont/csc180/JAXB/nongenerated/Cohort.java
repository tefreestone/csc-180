package edu.neumont.csc180.JAXB.nongenerated;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Cohort {

    @XmlAttribute
    protected int number;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @XmlElement
    protected List<Student> students;

    public List<Student> getStudents() {
        if (students == null) {
            students = new ArrayList<>();
        }
        return this.students;
    }
}
