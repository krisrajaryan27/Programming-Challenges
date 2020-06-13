package com.nirvana.learning.techverito.model;

import java.util.List;

/**
 * Author: Krishna Verma
 */

/**
 * POJO of Movie Class
 */
public class Movie {

    private int showNum;

    private List<Seat> seatList;

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
