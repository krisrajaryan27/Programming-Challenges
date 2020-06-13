package com.nirvana.learning.educative.codingpatterns.slidingwindow;


/**
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 */
public class MaxSumOfSubArraysOfSizeK {
    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumOfSubArraysOfSizeK.findMaxSumSubArrayBrute(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumOfSubArraysOfSizeK.findMaxSumSubArrayBrute(2, new int[]{2, 3, 4, 1, 5}));

        System.out.println("Maximum sum of a subarray of size K Optimised: "
                + MaxSumOfSubArraysOfSizeK.findMaxSumSubArrayOptimised(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K Optimised: "
                + MaxSumOfSubArraysOfSizeK.findMaxSumSubArrayOptimised(2, new int[]{2, 3, 4, 1, 5}));
    }

    //O(N*K)
    public static int findMaxSumSubArrayBrute(int k, int[] arr) {
        int maxSum = 0, windowSum;
        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    //O(N)
    public static int findMaxSumSubArrayOptimised(int k, int[] arr) {
        int windowSum = 0;
        int windowStart = 0;
        int maxSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }
}
