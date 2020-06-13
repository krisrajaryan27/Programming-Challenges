package com.nirvana.learning.projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author KrishnaV
 */
public class MultiplesOfThreeAndFive {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (isDivisibleByThree(i) || isDivisibleByFive(i)) {
                sum += i;
            }

        }
        System.out.println(sum);
    }

    private static boolean isDivisibleByThree(int num) {
        return num % 3 == 0;
    }

    private static boolean isDivisibleByFive(int num) {
        return num % 5 == 0;
    }
}
