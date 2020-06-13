package com.nirvana.learning.educative.dynamicprogramming;

public class Fibonacci {
    public int calculateFibonacciRecursive(int n) {
        if (n < 2)
            return n;
        return calculateFibonacciRecursive(n - 1) + calculateFibonacciRecursive(n - 2);
    }

    public int calculateFibonacciMemoization(int n) {
        int[] memoize = new int[n + 1];
        return calculateFibonacciMemoization(n, memoize);
    }

    private int calculateFibonacciMemoization(int n, int[] memoize) {
        if (n < 2)
            return n;
        if (memoize[n] != 0)
            return memoize[n];
        memoize[n] = calculateFibonacciMemoization(n - 1, memoize) + calculateFibonacciMemoization(n - 2, memoize);
        return memoize[n];
    }

    public int calcuateFibonacciTabulation(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        //base cases
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }
}
