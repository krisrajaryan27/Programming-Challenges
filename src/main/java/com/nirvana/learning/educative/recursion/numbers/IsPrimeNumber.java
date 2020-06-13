package com.nirvana.learning.educative.recursion.numbers;

import java.io.IOException;

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

    public static void main(String[] args) throws IOException {
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

    //O(N^1/2)
    public void isPrime(int n) {
        if (n <= 1) {
            System.out.println("Not prime");
        } else if (n <= 3) {
            System.out.println("Prime");
        } else if (n % 2 == 0 || n % 3 == 0) {
            System.out.println("Not prime");
        } else {
            boolean status = false;
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    status = true;
                    break;
                }
            }
            if (!status) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }

}
