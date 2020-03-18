package com.nirvana.learning.educative.recursion.numbers;

public class Square {
    // Recursive method to calculate square of a number
    private static int square(int n) {

        // Base case
        if (n == 0) {
            return 0;
        }

        // Recursive case
        else {
            return square(n - 1) + (2 * n) - 1;
        }
    }

    public static void main(String[] args) {
        int input = 6;
        int output = square(input);
        System.out.println("The square of the number " + input + " is: " + output);
    }
}
