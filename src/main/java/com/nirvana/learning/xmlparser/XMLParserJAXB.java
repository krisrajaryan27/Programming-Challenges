package com.nirvana.learning.xmlparser;

import com.nirvana.learning.xmlparser.model.FosterHomePOJO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XMLParserJAXB {

    public static void main(String[] args) throws JAXBException {

        String fosterHomeXML = XMLRecord.getFosterHomeXML();

        JAXBContext jaxbContext = JAXBContext.newInstance(FosterHomePOJO.class);


        Unmarshaller unmarshallerObj = jaxbContext.createUnmarshaller();

        StringReader stringReader = new StringReader(fosterHomeXML);
        FosterHomePOJO fosterHomePOJO = (FosterHomePOJO) unmarshallerObj.unmarshal(stringReader);

        System.out.println(fosterHomePOJO.toString());


    }
}
