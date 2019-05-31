package com.nirvana.learning.xmlparser;

public class XMLRecord {

    private final static String xmlRecords = "<?xml version=\"1.0\"?>\n" +
            "<COMMAND>\n" +
            "    <DATA>\n" +
            "        <TXNID>1234567891</TXNID>\n" +
            "        <TXNAMT>15.00</TXNAMT>\n" +
            "        <TXNID>1234567892</TXNID>\n" +
            "        <TXNAMT>15.00</TXNAMT>\n" +
            "        <TXNID>1234567893</TXNID>\n" +
            "        <TXNAMT>15.00</TXNAMT>\n" +
            "        <TXNID>1234567894</TXNID>\n" +
            "        <TXNAMT>15.00</TXNAMT>\n" +
            "    </DATA>\n" +
            "</COMMAND>";

    private final static String fosterHomeXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<FosterHome>\n" +
            "    <Orphanage>Happy Days Daycare</Orphanage>\n" +
            "    <Location>Apple Street</Location>\n" +
            "    <Families>\n" +
            "        <Family>\n" +
            "            <ParentID>Adams</ParentID>\n" +
            "            <ChildList>\n" +
            "                <ChildID>Child1</ChildID>\n" +
            "                <ChildID>Child2</ChildID>\n" +
            "            </ChildList>\n" +
            "        </Family>\n" +
            "        <Family>\n" +
            "            <ParentID>Adams</ParentID>\n" +
            "            <ChildList>\n" +
            "                <ChildID>Child3</ChildID>\n" +
            "                <ChildID>Child4</ChildID>\n" +
            "            </ChildList>\n" +
            "        </Family>\n" +
            "    </Families>\n" +
            "    <RemainingChildList>\n" +
            "        <ChildID>Child5</ChildID>\n" +
            "        <ChildID>Child6</ChildID>\n" +
            "    </RemainingChildList>\n" +
            "</FosterHome>";

    public static String getXmlRecords() {
        return xmlRecords;
    }

    public static String getFosterHomeXML() {
        return fosterHomeXML;
    }
}
