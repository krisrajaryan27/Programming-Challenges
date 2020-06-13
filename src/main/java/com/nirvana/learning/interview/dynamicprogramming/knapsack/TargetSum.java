package com.nirvana.learning.interview.dynamicprogramming.knapsack;

/**
 * Given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * <p>
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * <p>
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * This is same problem as count of subset for given difference.
 * https://leetcode.com/problems/target-sum/
 */
public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int[] arr1 = {1};
        int[] arr2 = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        int difference = 3;
        int difference1 = 2;
        int difference2 = 1;
        System.out.println(noOfWaysToAssignSignToGetDifferenceOfSubsetSum(arr, difference));
        System.out.println(noOfWaysToAssignSignToGetDifferenceOfSubsetSum(arr1, difference1));
        System.out.println(noOfWaysToAssignSignToGetDifferenceOfSubsetSum(arr2, difference2));
    }

    private static int noOfWaysToAssignSignToGetDifferenceOfSubsetSum(int[] arr, int diff) {
        return CountOfSubsetForGivenDifference.countOfSubsetSumDiffForGivenDiff(arr, diff);
    }
}
