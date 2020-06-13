package com.nirvana.learning.interview.dynamicprogramming.knapsack;

import static com.nirvana.learning.interview.dynamicprogramming.knapsack.SubsetProblem.isSubsetPresent;


/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets
 * such that the sum of elements in both subsets is same.
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 */
public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        System.out.println(findEqualPartition(arr));

    }

    private static boolean findEqualPartition(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return isSubsetPresent(arr, sum / 2);
    }
}
