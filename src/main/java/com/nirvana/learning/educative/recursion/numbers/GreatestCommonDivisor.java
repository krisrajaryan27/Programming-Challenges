package com.nirvana.learning.educative.recursion.numbers;

public class GreatestCommonDivisor {

    // Euclid's Method
    public static int gcdEuclid(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcdEuclid(num2, num1 % num2);
    }

    public static int gcd(int num1, int num2) {
        // Base case
        if (num1 == num2) {
            return num1;
        }
        // Recursive case
        if (num1 > num2) {
            return gcd(num1 - num2, num2);
        } else {
            return gcd(num1, num2 - num1);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcdEuclid(48, 60));
        System.out.println(gcd(48, 60));
    }
}
