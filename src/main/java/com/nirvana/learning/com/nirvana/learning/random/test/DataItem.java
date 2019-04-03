package com.nirvana.learning.com.nirvana.learning.random.test;

import lombok.Data;

@Data
public class DataItem {
    private String TXNID;
    private String TXNAMT;

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

    public DataItem(String TXNID, String TXNAMT) {
        this.TXNID = TXNID;
        this.TXNAMT = TXNAMT;
    }
    public DataItem() {
    }

}
