package com.nirvana.learning.techverito.client;

import com.nirvana.learning.techverito.service.MovieService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieApplication {

    public static void main(String[] args) throws IOException {
        MovieService movieService = new MovieService();
        movieService.createMovieArrangement();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Show no: ");
        int showNum = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter seats: ");
        String seats[] = bufferedReader.readLine().split(",");
    }



}
