package com.nirvana.learning.interview.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The digital root of a positive integer is found by summing the digits of the integer. If the resulting value is a single digit then that digit is the digital root. If the resulting value contains two or more digits, those digits are summed and the process is repeated. This is continued as long as necessary to obtain a single digit.
 * <p>
 * Given a number, the task is to find its digital root. The input number may be large and it may not be possible to store even if we use long long int.
 * https://www.geeksforgeeks.org/digital-rootrepeated-digital-sum-given-integer/
 */
public class DigitalRoot {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        while (testCases > 0) {
            long num = Long.parseLong(bufferedReader.readLine());
            digitalRoot(num);
            testCases--;
        }

    }

    public static void digitalRoot(long num) {
        int noOfIteration = 0;
        if (num <= 9) {
            System.out.println("Single Digit Num is: " + num + " and No. of Iterations to calculate it is: " + noOfIteration);
            return;
        }
        long root = sumDigits(num);
        noOfIteration = 1;
        while (root > 9) {
            root = sumDigits(root);
            noOfIteration++;
        }
        System.out.println("Single Digit Num is: " + root + " and No. of Iterations to calculate it is: " + noOfIteration);
    }

    public static long sumDigits(long num) {
        return num == 0 ? 0 : num % 10 +
                sumDigits(num / 10);
    }
}
