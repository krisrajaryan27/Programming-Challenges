package com.nirvana.learning.techverito.client;

import com.nirvana.learning.techverito.service.MovieService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author: Krishna Verma
 */

/**
 * Client Class to test different scenarios of  movie seating arrangement
 */
public class MovieApplication {

    public static void main(String[] args) throws IOException {
        MovieService movieService = new MovieService();
        movieService.printAvailableSeats(true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Show no: ");
        int showNum = Integer.parseInt(bufferedReader.readLine());
        System.out.println();
        System.out.print("Enter seats: ");
        String[] seats = bufferedReader.readLine().split(",");
        System.out.println();
        boolean seatStatus = true;
        for (String seat : seats) {
            if (!movieService.isSeatAvailable(showNum, seat)) {
                System.out.println(seat + " Not available, Please select different seats");
                seatStatus = false;
                break;
            }
        }
        if (seatStatus) {
            double subTotal = movieService.calculateSubTotal(showNum, seats);
            double serviceTax = movieService.calculateTax(subTotal, 14);
            double swacchBrtTax = movieService.calculateTax(subTotal, 0.5);
            double krishKalTax = movieService.calculateTax(subTotal, 0.5);
            double total = subTotal + serviceTax + swacchBrtTax + krishKalTax;
            System.out.println("Successfully Booked - Show " + showNum);
            System.out.println("SubTotal: Rs. " + subTotal);
            System.out.println("Service Tax @14%: Rs. " + serviceTax);
            System.out.println("Swachh Bharat Cess @0.5%: Rs. " + swacchBrtTax);
            System.out.println("Krishi Kalyan Cess @0.5%: Rs. " + krishKalTax);
            System.out.println("Total: Rs. " + total);
        }
        movieService.printAvailableSeats(false);
    }
}

