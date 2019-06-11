package com.nirvana.learning.techverito.service;

import com.nirvana.learning.techverito.model.Movie;
import com.nirvana.learning.techverito.model.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateMovieShow {

    public Map<Integer,Movie> createMovieArrangement(){
        Map<Integer,Movie> movieMap = new HashMap<>();
        Movie movie1 = new Movie();
        movie1.setShowNum(1);
        List<Seat> seatList1 = new ArrayList<>();
        for(int i=1; i<=9;i++) {
            Seat seat = new Seat();
            seat.setSeatNum(i);
            seat.setSeatType("A");
            seatList1.add(seat);
        }
        for(int i=1;i<=6;i++) {
            Seat seat = new Seat();
            seat.setSeatNum(i);
            seat.setSeatType("B");
            seatList1.add(seat);
        }
        for(int i=2;i<=7;i++) {
            Seat seat = new Seat();
            seat.setSeatNum(i);
            seat.setSeatType("C");
            seatList1.add(seat);
        }
        movie1.setSeatList(seatList1);
        movieMap.put(1,movie1);

        Movie movie2 = new Movie();
        movie2.setShowNum(2);
        List<Seat> seatList2 = new ArrayList<>();
        for(int i=1; i<=7;i++) {
            Seat seat = new Seat();
            seat.setSeatNum(i);
            seat.setSeatType("A");
            seatList2.add(seat);
        }
        for(int i=2;i<=6;i++) {
            Seat seat = new Seat();
            seat.setSeatNum(i);
            seat.setSeatType("B");
            seatList2.add(seat);
        }
        for(int i=1;i<=7;i++) {
            Seat seat = new Seat();
            seat.setSeatNum(i);
            seat.setSeatType("C");
            seatList2.add(seat);
        }
        movie2.setSeatList(seatList2);
        movieMap.put(2,movie2);

        Movie movie3 = new Movie();
        movie3.setShowNum(2);
        List<Seat> seatList3 = new ArrayList<>();
        for(int i=1; i<=5;i++) {
            Seat seat = new Seat();
            seat.setSeatNum(i);
            seat.setSeatType("A");
            seatList3.add(seat);
        }
        for(int i=1;i<=8;i++) {
            Seat seat = new Seat();
            seat.setSeatNum(i);
            seat.setSeatType("B");
            seatList3.add(seat);
        }
        for(int i=1;i<=9;i++) {
            Seat seat = new Seat();
            seat.setSeatNum(i);
            seat.setSeatType("C");
            seatList3.add(seat);
        }
        movie3.setSeatList(seatList3);
        movieMap.put(3,movie3);

        return movieMap;
    }


}
