package com.nirvana.learning.enums;

public enum Teams {
    LENGABURU("Lengaburu"),ENCHAI("Enchai");

    private String value;

    Teams(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
