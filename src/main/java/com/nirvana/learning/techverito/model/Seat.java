package com.nirvana.learning.techverito.model;

public class Seat {

    private String seatType;

    private int seatNum;

    public Seat() {
    }

    public Seat(String seatType, int seatNum) {
        this.seatType = seatType;
        this.seatNum = seatNum;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
}
