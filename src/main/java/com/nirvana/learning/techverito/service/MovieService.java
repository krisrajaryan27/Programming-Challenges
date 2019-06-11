package com.nirvana.learning.techverito.service;

import com.nirvana.learning.techverito.model.Seat;

import java.util.List;

public class MovieService {

    public void showMovieSeatArrangement(){
        CreateMovieShow createMovieShow = new CreateMovieShow();
        System.out.println("Seating Arrangement: ");
        for(int i: createMovieShow.createMovieArrangement().keySet()){
            System.out.println("Show "+i+" Running in Audi "+i+":");
            System.out.println("All Seats:");
            List<Seat> seatList = createMovieShow.createMovieArrangement().get(i).getSeatList();
            seatList.stream()
                    .reduce("",);

        }
    }

    public boolean isSeatAvailable(){
        return true;
    }

    public void printAvailableSeats(){

    }

    public double calculateSubTotal(){
        return 0.0;
    }

    public double calculateTax(){
        return 0.0;
    }

    public double calculateTotalPrice(){
        return 0.0;
    }




}
