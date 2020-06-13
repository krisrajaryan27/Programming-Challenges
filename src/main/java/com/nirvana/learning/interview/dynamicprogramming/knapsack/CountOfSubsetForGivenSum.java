package com.nirvana.learning.interview.dynamicprogramming.knapsack;

/**
 * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
 * Input: arr[] = {1, 2, 3, 3}, X = 6
 * Output: 3
 * All the possible subsets are {1, 2, 3},
 * {1, 2, 3} and {3, 3}
 * https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
 */
public class CountOfSubsetForGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        int sum = 6;
        System.out.println(countOfSubsetSumForGivenSum(arr, sum));
    }

    public static int countOfSubsetSumForGivenSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] t = new int[n + 1][sum + 1];
        for (int j = 0; j <= sum; j++) {
            t[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= sum; j++) {
//                System.out.print(t[i][j] + " ");
//            }
//            System.out.println("");
//        }
        return t[n][sum];
    }
}
