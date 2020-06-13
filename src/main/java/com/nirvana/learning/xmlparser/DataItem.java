package com.nirvana.learning.xmlparser;

import lombok.Data;

@Data
public class DataItem {
    private String TXNID;
    private String TXNAMT;

    public DataItem(String TXNID, String TXNAMT) {
        this.TXNID = TXNID;
        this.TXNAMT = TXNAMT;
    }

    public DataItem() {
    }

    public String getTXNID() {
        return TXNID;
    }

    public void setTXNID(String TXNID) {
        this.TXNID = TXNID;
    }

    public String getTXNAMT() {
        return TXNAMT;
    }

    public void setTXNAMT(String TXNAMT) {
        this.TXNAMT = TXNAMT;
    }

}
