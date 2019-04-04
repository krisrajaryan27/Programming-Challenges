package com.nirvana.learning.geektrust.enums;

public enum MatchType {

    DAY("Day"),NIGHT("Night");

    private String value;

    MatchType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
