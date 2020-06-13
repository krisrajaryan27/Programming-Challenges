package com.nirvana.learning.basicprogramming.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciMember {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.println(checkIfFibonacciMember(n));
    }

    private static boolean checkIfFibonacciMember(int n) {
        if (n < 0) {
            return false;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        boolean status = false;
        for (int i = 0; i < fib.length; i++) {
            if (n == fib[i]) {
                status = true;
                break;
            }
        }
        return status;
    }
}
