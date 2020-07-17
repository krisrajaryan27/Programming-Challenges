package com.nirvana.learning.interview.array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(input));
        System.out.println(maxSubArrayKadane(input));
    }

    public static int maxSubArray(int[] arr) {

        int max = Integer.MIN_VALUE;
        int curr = 0;

        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            if (curr < arr[i]) curr = arr[i];
            if (curr > max) max = curr;
        }
        return max;
    }

    //Kadane Algorithm
    public static int maxSubArrayKadane(int[] arr) {
        int maxCurrent = arr[0];
        int maxGlobal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }
}
