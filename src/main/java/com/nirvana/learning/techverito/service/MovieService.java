package com.nirvana.learning.techverito.service;

import com.nirvana.learning.techverito.model.Movie;
import com.nirvana.learning.techverito.model.Seat;

import java.util.*;
/** Author: Krishna Verma*/
/** Service Class with business logic of movie seating arrangement*/
public class MovieService {

    private Map<Integer, List<String>> movieSeatMap = new HashMap<>();

    private Map<Integer,Movie> movieArrangementMap = new HashMap<>();

    private Map<Integer, Movie> movieMap = new HashMap<>();

    /** Prints the available seats based on the status whether it is initial arrangement or after booking*/
    public Map<Integer, List<String>> printAvailableSeats(boolean isInitialSeatArrangement){
        int count = 0;
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

    /** Creates the seating arrangement of the movie show initially*/
    public Map<Integer, Movie> getCreatedMovieMap(){
        CreateMovieShow createMovieShow = new CreateMovieShow();
        movieArrangementMap = createMovieShow.createMovieArrangement();
        return movieArrangementMap;
    }

    /** Validates whether the seat which is being booked is available or not based on show Number*/
    public boolean isSeatAvailable(int showNum, String seat){
        if(!movieSeatMap.get(showNum).contains(seat)){
            return false;
        }
        return true;
    }

    /** Calculates the subtotal amount for the movie booking*/
    public double calculateSubTotal(int showNum, String[] seats){
        double subTotal = 0.0;
        for(String seat: seats){
            if(seat.contains("A")){
                subTotal+=320;
            } else if(seat.contains("B")){
                subTotal+=280;
            } else if(seat.contains("C")){
                subTotal+=240;
            }
            updateSeatArrangementMap(showNum,seat);
        }
        return subTotal;
    }
    /** Updates the seat availability after booking*/
    public void updateSeatArrangementMap(int showNum, String seatString){
        Movie movie = movieMap.get(showNum);
        List<Seat> seatList = movie.getSeatList();
        Iterator<Seat> iter = seatList.iterator();
        while (iter.hasNext()){
            Seat seat = iter.next();
            if(seat.getSeatType().equalsIgnoreCase(String.valueOf(seatString.charAt(0)))
                    && seat.getSeatNum() == Integer.parseInt(String.valueOf(seatString.charAt(1)))){
                iter.remove();
            }
        }
        movie.setSeatList(seatList);
        movieMap.put(showNum,movie);
    }
    /** Calculates the different taxes incurred while booking the ticket*/
    public double calculateTax(double value, double rate){
        return value+(value*rate)/100;
    }
}
