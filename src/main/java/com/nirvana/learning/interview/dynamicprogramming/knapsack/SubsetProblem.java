package com.nirvana.learning.interview.dynamicprogramming.knapsack;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set
 * with sum equal to given sum.
 * Example:
 * <p>
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True
 * <p>
 * There is a subset (4, 5) with sum 9.
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * There is no subset that add up to 30.
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 */
public class SubsetProblem {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        System.out.println(isSubsetPresent(arr, sum));
    }

    static boolean isSubsetSum(int[] arr, int n, int sum) {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        /* Check if sum can be obtained by any of
           the following
        (a) including the last element
        (b) excluding the last element
        */
        if (arr[n - 1] <= sum)
            return isSubsetSum(arr, n - 1, sum - arr[n - 1]) || isSubsetSum(arr, n - 1, sum);

        // If last element is greater than sum, then ignore it
        return isSubsetSum(arr, n - 1, sum);


    }

    public static boolean isSubsetPresent(int[] arr, int sum) {
        boolean[][] t = new boolean[arr.length + 1][sum + 1];
        for (int j = 0; j < sum + 1; j++) {
            t[0][j] = false;
        }
        for (int i = 0; i < arr.length; i++) {
            t[i][0] = true;
        }
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[arr.length][sum];
    }

}
