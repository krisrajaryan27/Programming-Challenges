package com.nirvana.learning.basicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeapYear {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(bufferedReader.readLine().trim());
        boolean isLeapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        System.out.println(isLeapYear);

    }
}
