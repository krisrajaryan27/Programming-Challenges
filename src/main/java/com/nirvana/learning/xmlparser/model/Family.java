package com.nirvana.learning.xmlparser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Family {

    @XmlElement(name = "ParentID")
    private String parentId;

    @XmlElementWrapper(name = "ChildrenList")
    @XmlElement(name = "ChildID")
    private List<String> childList;

    @Override
    public String toString() {
        return "Family{" +
                "parentId='" + parentId + '\'' +
                ", childList=" + childList +
                '}';
    }
}
