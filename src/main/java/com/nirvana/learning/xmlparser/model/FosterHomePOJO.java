package com.nirvana.learning.xmlparser.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "FosterHome")
@XmlAccessorType(XmlAccessType.FIELD)
public class FosterHomePOJO {

    @XmlElement(name = "Orphanage")
    private String orphanage;

    @XmlElement(name = "Location")
    private String location;

    @XmlElementWrapper(name = "Families")
    @XmlElement(name = "Family")
    private List<Family> families;

    @XmlElementWrapper(name = "RemainingChildrenList")
    @XmlElement(name = "ChildID")
    private List<String> remainingChildren;

    @Override
    public String toString() {
        return "FosterHomePOJO{" +
                "orphanage='" + orphanage + '\'' +
                ", location='" + location + '\'' +
                ", families=" + families +
                ", remainingChildren=" + remainingChildren +
                '}';
    }
}
