package com.nirvana.learning.hackerearth;

public class FibonacciDP {

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }

    public static int fibonacci(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
