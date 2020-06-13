package com.nirvana.learning.interview.dynamicprogramming.knapsack;

import java.util.Arrays;

/**
 * Given a set of integers, the task is to divide it into two sets S1 and S2
 * such that the absolute difference between their sums is minimum.
 * If there is a set S with n elements, then if we assume Subset1 has m elements,
 * Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * <p>
 * Example:
 * Input:  arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 */
public class MinimumDifferenceOfSubsetSum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 2, 1};
        int[] arr1 = {1, 6, 11, 5};
        System.out.println(minimumDifferenceOfSubsetSum(arr));
        System.out.println(minimumDifferenceOfSubsetSum(arr1));
    }

    private static int minimumDifferenceOfSubsetSum(int[] arr) {
        int rangeSum = Arrays.stream(arr).sum();
        boolean[][] t = subsetSum(arr, rangeSum);
        int difference = Integer.MAX_VALUE;
        //Method1 - Either list out all the sums which are possible and then find the minimum difference
        /*Vector<Integer> list = new Vector<>();
        for (int j = 0; j <= rangeSum / 2; j++) {
            if (t[arr.length][j]) {
                list.add(j);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            difference = Math.min(difference, rangeSum - 2 * list.get(i));
        }*/

        //Method2 - Iterate from the mid point to find the first sum which is possible as its difference will be minimum
        for (int j = rangeSum / 2; j >= 0; j--) {
            if (t[arr.length][j]) {
                difference = rangeSum - 2 * j;
                break;
            }
        }
        return difference;
    }

    private static boolean[][] subsetSum(int[] arr, int sum) {
        boolean[][] t = new boolean[arr.length + 1][sum + 1];
        for (int j = 0; j < sum + 1; j++) {
            t[0][j] = false;
        }
        for (int i = 0; i < arr.length + 1; i++) {
            t[i][0] = true;
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t;
    }
}
