package com.nirvana.learning.techverito.model;

public class Seat {

    private String seatType;

    private int seatNum;

    private boolean isAvailable;

    public Seat() {
    }

    public Seat(String seatType, int seatNum, boolean isAvailable) {
        this.seatType = seatType;
        this.seatNum = seatNum;
        this.isAvailable = isAvailable;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
