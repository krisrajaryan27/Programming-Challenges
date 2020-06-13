package com.nirvana.learning.interview.dynamicprogramming.unboundedknapsack;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * Example:
 * if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * length: 1 2 3 4 5 6 7 8
 * price: 1 5 8 9 10 17 17 20
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 */
public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int maxLength = 8;
        System.out.println(maximumProfit(length, price, length.length, maxLength));

    }

    private static int maximumProfit(int[] length, int[] price, int size, int maxLength) {
        return UnboundedKnapsack.maximumProfitWithRepetitionAllowed(length, price, size, maxLength);
    }
}
