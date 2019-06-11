package com.nirvana.learning.techverito.service;

import com.nirvana.learning.techverito.model.Movie;
import com.nirvana.learning.techverito.model.Seat;
import com.nirvana.learning.techverito.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieService {

    private Map<Integer, List<String>> movieSeatMap = new HashMap<>();

    private Map<Integer,Movie> movieArrangementMap = new HashMap<>();

    private Map<Integer, Movie> movieMap = new HashMap<>();

    public Map<Integer, List<String>> getMovieSeatMap() {
        return movieSeatMap;
    }

    public Map<Integer, Movie> getMovieArrangementMap() {
        return movieArrangementMap;
    }

    public Map<Integer, Movie> getMovieMap() {
        return movieMap;
    }

    public Map<Integer, List<String>> printAvailableSeats(boolean isInitialSeatArrangement){
        Util util = new Util();
        int count = 0;
        String append = util.getAppender().get(0);
        if(isInitialSeatArrangement){
            movieMap = getCreatedMovieMap();
        }
        System.out.println("Seating Arrangement: ");
        for(int i: movieMap.keySet()){
            System.out.println("Show "+i+" Running in Audi "+i+":");
            System.out.println("All Seats:");
            List<Seat> seatList = movieMap.get(i).getSeatList();
            List<String> seatStringList = new ArrayList<>();
            for(Seat seat : seatList){
                String seatDetails = seat.getSeatType()+""+seat.getSeatNum();
                if(count < seat.getSeatNum()) {
                    System.out.print(seatDetails + " ");
                    count=seat.getSeatNum();
                } else if(count>seat.getSeatNum()){
                    count = 1;
                    System.out.println();
                    System.out.print(seatDetails+" ");
                }
                seatStringList.add(seatDetails);
                movieSeatMap.put(i,seatStringList);
            }
            System.out.println();
        }
        return movieSeatMap;
    }


    public Map<Integer, Movie> getCreatedMovieMap(){
        CreateMovieShow createMovieShow = new CreateMovieShow();
        movieArrangementMap = createMovieShow.createMovieArrangement();
        return movieArrangementMap;
    }

    public boolean isSeatAvailable(int showNum, String seat){
        if(!movieSeatMap.get(showNum).contains(seat)){
            return false;
        }
        return true;
    }

    public double calculateSubTotal(int showNum, String seats[]){
        double subTotal = 0.0;
        for(String seat: seats){
            if(seat.contains("A")){
                subTotal+=320;
                updateSeatArrangementMap(showNum,seat);
            } else if(seat.contains("B")){
                subTotal+=280;
                updateSeatArrangementMap(showNum,seat);
            } else if(seat.contains("C")){
                subTotal+=240;
                updateSeatArrangementMap(showNum,seat);
            }
        }
        return subTotal;
    }
    public void updateSeatArrangementMap(int showNum, String seatString){
        Movie movie = movieMap.get(showNum);
        List<Seat> seatList = movie.getSeatList();
        List<Seat> updatedList = new ArrayList<>();
        updatedList = seatList;
        for(Seat seat: seatList){
            boolean value = seat.getSeatNum() == Integer.parseInt(String.valueOf(seatString.charAt(1))) ? true:false;
            if(seat.getSeatType().equalsIgnoreCase(String.valueOf(seatString.charAt(0))) && value){
                updatedList.remove(seat);
            }
        }
        movie.setSeatList(updatedList);
        movieMap.put(showNum,movie);


    }
    public double calculateTax(double value, double rate){
        return value+(value*rate)/100;
    }

    public double calculateTotalPrice(){
        return 0.0;
    }




}
