package edu.neumont.csc180.JAXB.Marshal;/*package generated.example;
import generated.Cohort;
import generated.Enrollment;
import generated.Student;

import java.io.File;
import java.text.MessageFormat;

import javax.swing.JFrame;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshalXML extends JFrame{
	
	public static void main(String[] args){
		
		try{
			
			//Create a JAXB Context and Unmarshaller
			JAXBContext context = JAXBContext.newInstance("generated");
			Unmarshaller unmarsh = context.createUnmarshaller();
			
			//unmarshall the document
			Enrollment enroll = (Enrollment)unmarsh.unmarshal(new File("test.xml"));
			
			int i = 0;
			for (Cohort c : enroll.getCohorts()){
				System.out.println(MessageFormat.format("Cohort {0}:", ++i));
				for (Student s : c.getStudents()){
					System.out.println(MessageFormat.format("\t{0}, {1}, {2}",
															s.getName(),
															s.getEmail(),
															s.getPassword()));
				}
			}
			
		} catch (JAXBException e){
			e.printStackTrace();
		}
	}
}
*/