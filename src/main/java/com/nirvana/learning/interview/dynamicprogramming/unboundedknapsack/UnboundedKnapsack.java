package com.nirvana.learning.interview.dynamicprogramming.unboundedknapsack;

/**
 * Given a knapsack weight W and a set of n items with certain value val_i and weight wt_i,
 * we need to calculate minimum amount that could make up this quantity exactly
 * <p>
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 * Input : W = 100
 * val[]  = {1, 30}
 * wt[] = {1, 50}
 * Output : 100
 * There are many ways to fill knapsack.
 * 1) 2 instances of 50 unit weight item.
 * 2) 100 instances of 1 unit weight item.
 * 3) 1 instance of 50 unit weight item and 50
 * instances of 1 unit weight items.
 * We get maximum value with option 2.
 * <p>
 * Input : W = 8
 * val[] = {10, 40, 50, 70}
 * wt[] = {1, 3, 4, 5}
 * Output : 110
 * We get maximum value with one unit of
 * weight 5 and one unit of weight 3.
 * https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
 */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] val = {10, 40, 50, 70};
        int[] wt = {1, 3, 4, 5};
        int W = 8;
        System.out.println(maximumProfitWithRepetitionAllowed(wt, val, wt.length, W));

    }

    public static int maximumProfitWithRepetitionAllowed(int[] wt, int[] val, int n, int W) {
        int[][] t = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= W; j++)
                if (i == 0 || j == 0)
                    t[i][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (wt[i - 1] <= j)
                    t[i][j] = Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][W];
    }
}
