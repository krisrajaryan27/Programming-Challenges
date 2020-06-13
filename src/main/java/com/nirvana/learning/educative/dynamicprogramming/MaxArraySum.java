package com.nirvana.learning.educative.dynamicprogramming;

/**
 * Given an array of integers, find the subset of non-adjacent elements with the maximum sum.
 * Calculate the sum of that subset.
 */
public class MaxArraySum {
    public static void main(String[] args) {
        int[] arr = {3, 7, 4, 6, 5};
        int[] arr1 = {2, 1, 5, 8, 4};
        int[] arr2 = {3, 5, -7, 8, 10};
        System.out.println(maxSubSum(arr));
        System.out.println(maxSubSum(arr1));
        System.out.println(maxSubSum(arr2));
    }

    public static int maxSubSum(int[] arr) {
        int n = arr.length;
        int incl = arr[0];
        int excl = 0;
        int exclNew;
        for (int i = 1; i < n; i++) {
            /* current max excluding i */
            exclNew = Math.max(incl, excl);
            /* current max including i */
            incl = excl + arr[i];
            excl = exclNew;
        }
        /* return max of incl and excl */
        return (Math.max(incl, excl));
    }
}
