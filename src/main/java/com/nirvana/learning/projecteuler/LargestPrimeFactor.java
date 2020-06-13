package com.nirvana.learning.projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author KrishnaV
 */
public class LargestPrimeFactor {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        long num = Long.parseLong(input);
        System.out.println(largestPrimeFactor(num));
    }

    private static long largestPrimeFactor(long num) {
        long maxPrime = Integer.MIN_VALUE;
        while (num % 2 == 0) {
            maxPrime = 2;
            num >>= 1;
        }
        for (int i = 3; i <= Math.sqrt(num); i++) {
            while (num % i == 0) {
                maxPrime = i;
                num /= i;
            }
        }
        if (num > 2) {
            maxPrime = num;
        }
        return maxPrime;
    }
}
