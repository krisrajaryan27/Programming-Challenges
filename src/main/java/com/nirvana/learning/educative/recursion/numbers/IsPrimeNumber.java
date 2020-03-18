package com.nirvana.learning.educative.recursion.numbers;

public class IsPrimeNumber {
    public static boolean isPrimeIteratively(int num1, int num2) {
        for (int i = 2; i <= num2; i++) {
            if (num1 % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeRecursively(int num, int i) {
        // First base case
        if (num < 2) {
            return false;
        }
        // Second base case
        else if (i == 1) {
            return true;
        }
        // Third base case
        else if (num % i == 0) {
            return false;
        }
        // Recursive case
        else {
            return isPrimeRecursively(num, i - 1);
        }
    }

    public static void main(String[] args) {
        int input = 13;
        boolean result = isPrimeIteratively(input, input / 2);

        // Print if the number is prime
        if (result == true) {
            System.out.println(input + " is a prime number as found iteratively");
        }
        // Prints if the number is NOT a prime number
        else {
            System.out.println(input + " is NOT a prime number as found iteratively");
        }

        input = 17;
        result = isPrimeIteratively(input, input / 2);

        // Print if the number is prime
        if (result == true) {
            System.out.println(input + " is a prime number as found recursively");
        }
        // Prints if the number is NOT a prime number
        else {
            System.out.println(input + " is NOT a prime number as found recursively");
        }
    }

}
