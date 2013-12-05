package edu.neumont.csc180.JAXB.Marshal;

import edu.neumont.csc180.JAXB.generated.Cohort;
import edu.neumont.csc180.JAXB.generated.Enrollment;
import edu.neumont.csc180.JAXB.generated.Student;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.MessageFormat;

public class UnmarshalXML extends JFrame {

    public static void main(String[] args) {

        try {
            //Create a JAXB Context and Unmarshaller
            JAXBContext context = JAXBContext.newInstance("edu.neumont.csc180.JAXB.generated");
            Unmarshaller unmarsh = context.createUnmarshaller();

            //unmarshall the document
            Enrollment enroll = (Enrollment) unmarsh.unmarshal(new File("/projects/csc-180/csc-180/src/edu/neumont/csc180/JAXB/test.xml"));

            int i = 0;
            for (Cohort c : enroll.getCohorts()) {
                System.out.println(MessageFormat.format("Cohort {0}:", ++i));
                for (Student s : c.getStudents()) {
                    System.out.println(MessageFormat.format("\t{0}, {1}, {2}",
                            s.getName(),
                            s.getEmail(),
                            s.getPassword()));
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
