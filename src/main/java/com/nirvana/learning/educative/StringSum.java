package com.nirvana.learning.educative;

/**
 * You are provided a positive integer n and asked to construct all strings of 1s, 2s, and 3s that would sum up to n. For example,
 * if n = 3, then the following strings will sum up to n:
 * 111
 * 12
 * 21
 * 3
 * Method1- Recursive Approach
 * Method2 - Top Down Dynamic Programming
 * Method 3
 */
public class StringSum {
    static int[] computed;

    public static void main(String[] args) {
        //Method 1
        long start = System.currentTimeMillis();
        int result = StringSumCountRecursive(5);
        long end = System.currentTimeMillis();
        System.out.println("Number of Strings : " + result + "    Time taken for recursive method = " + (end - start));

        //Method2
        start = System.currentTimeMillis();
        int n = 50;
        computed = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            computed[i] = -1;

        System.out.println(StringSumCountTopDown(n));
        end = System.currentTimeMillis();
        System.out.println("Time taken for top down dp method= " + (end - start));

        //Method3
        start = System.currentTimeMillis();
        System.out.println(StringSumCountBottomUp(n));
        end = System.currentTimeMillis();
        System.out.println("Time taken for bottom up dp method = " + (end - start));

    }

    static int StringSumCountRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 1) {
            return 0;
        }
        int sum = 0;
        // Number of ways to represent with 1
        sum += StringSumCountRecursive(n - 1);
        // Number of ways to represent with 2
        sum += StringSumCountRecursive(n - 2);
        // Number of ways to represent with31
        sum += StringSumCountRecursive(n - 3);
        return sum;
    }

    static int StringSumCountTopDown(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 1) {
            return 0;
        }
        // If solution is already calculated
        if (computed[n] != -1)
            return computed[n];
        int sum = 0;
        // Number of ways to represent with 1
        sum += StringSumCountTopDown(n - 1);
        // Number of ways to represent with 2
        sum += StringSumCountTopDown(n - 2);
        // Number of ways to represent with31
        sum += StringSumCountTopDown(n - 3);
        computed[n] = sum;
        return sum;
    }

    static int StringSumCountBottomUp(int n) {

        int[] computed = new int[n + 1];
        computed[0] = 0;
        computed[1] = 1;
        computed[2] = 2;
        computed[3] = 4;

        for (int i = 4; i < n + 1; i++) {
            computed[i] = computed[i - 1] + computed[i - 2] + computed[i - 3];
        }

        return computed[n];
    }


}
