
package edu.neumont.csc180.JAXB.nongenerated;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType
@XmlRootElement
public class Enrollment {

    @XmlElement
    protected List<Cohort> cohorts;

    public List<Cohort> getCohorts() {
        if (cohorts == null) {
            cohorts = new ArrayList<>();
        }
        return this.cohorts;
    }

}
