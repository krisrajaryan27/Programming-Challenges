package com.nirvana.learning.threads.connectionpool;

import java.util.Arrays;
import java.util.Objects;

public class TestConnectionPool {

    private String id;
    private int number;
    private byte[] arr;

    public TestConnectionPool(String id, int number, byte[] arr) {
        this.id = id;
        this.number = number;
        this.arr = arr;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public byte[] getArr() {
        return arr;
    }

    public void setArr(byte[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestConnectionPool that = (TestConnectionPool) o;
        return getNumber() == that.getNumber() &&
                Objects.equals(getId(), that.getId()) &&
                Arrays.equals(getArr(), that.getArr());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getNumber());
        result = 31 * result;
        return result;
    }


}
