package com.nirvana.learning.enums;

public enum WeatherType {

    CLEAR("Clear"),CLOUDY("Cloudy");

    private String value;

    WeatherType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
