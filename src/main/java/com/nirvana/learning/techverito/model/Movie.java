package com.nirvana.learning.techverito.model;

import java.util.List;

public class Movie {

    private int showNum;

    private List<Seat> seatList;

    public Movie() {
    }

    public Movie(int showNum, List<Seat> seatList) {
        this.showNum = showNum;
        this.seatList = seatList;
    }

    public int getShowNum() {
        return showNum;
    }

    public void setShowNum(int showNum) {
        this.showNum = showNum;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
