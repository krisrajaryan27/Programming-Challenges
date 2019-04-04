package com.nirvana.learning.geektrust.cricket.enums;

public enum TossType {

    BOWLS("Bowls"),BATS("Bats");

    private String value;

    TossType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
