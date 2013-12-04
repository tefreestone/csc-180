package edu.neumont.csc180.JAXB.Marshal;

import generated.Cohort;
import generated.Enrollment;
import generated.ObjectFactory;
import generated.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MarshalXML {
    public static void main(String[] args) {
        ObjectFactory factory = new ObjectFactory();
        Enrollment enroll = factory.createEnrollment();
        Cohort one = factory.createCohort();
        enroll.getCohorts().add(one);
        Student s;
        s = factory.createStudent();
        s.setName("Jake");
        s.setEmail("jwalkenhorst@neumont.edu");
        s.setPassword("12345");
        one.getStudents().add(s);
        s = factory.createStudent();
        s.setName("Tim");
        s.setEmail("tclark@neumont.edu");
        s.setPassword("orm");
        one.getStudents().add(s);
        s = factory.createStudent();
        s.setName("Steve");
        s.setEmail("shalladay@neumont.edu");
        s.setPassword("bunnies");
        one.getStudents().add(s);
        Cohort two = factory.createCohort();
        enroll.getCohorts().add(two);
        s = factory.createStudent();
        s.setName("John");
        s.setEmail("jneumont@neumont.edu");
        s.setPassword("lol");
        two.getStudents().add(s);
        s = factory.createStudent();
        s.setName("Timmy");
        s.setEmail("tsmithy@neumont.edu");
        s.setPassword("wow");
        two.getStudents().add(s);
        try (OutputStream out = new FileOutputStream("test.xml")) {
            JAXBContext context = JAXBContext.newInstance("generated");
            Marshaller marsh = context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //human-readable output
            marsh.marshal(enroll, out); //Ouput the XML
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
