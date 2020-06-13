package com.nirvana.learning.interview.dynamicprogramming.knapsack;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W
 * to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1]
 * which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[]
 * such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        System.out.println(knapsackRecursive(wt, val, wt.length, W));
        System.out.println(knapsack(wt, val, wt.length, W));
    }

    private static int knapsackRecursive(int[] wt, int[] val, int n, int W) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsackRecursive(wt, val, n - 1, W - wt[n - 1]), knapsackRecursive(wt, val, n - 1, W));
        }
        return knapsackRecursive(wt, val, n - 1, W);
    }

    private static int knapsack(int[] wt, int[] val, int n, int W) {
        int[][] t = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
        }
        for (int j = 0; j <= W; j++) {
            t[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (wt[i - 1] <= j)
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][W];
    }
}
