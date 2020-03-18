package com.nirvana.learning.educative.recursion.numbers;

public class Fibonacci {

    public static int fibonacci(int num) {
        // Base case
        if (num <= 1) {
            return num;
        }
        // Recursive case
        else {
            return (fibonacci(num - 1) + fibonacci(num - 2));
        }
    }

    public static void main(String[] args) {
        int input = 5;
        System.out.println("Fibonacci sequences for the first " + input + " elements is:");

        // Loop to print all the fibonacci sequence elements
        int i = 0;
        while (i < input) {
            System.out.print(fibonacci(i) + " ");
            i++;
        }
    }
}
