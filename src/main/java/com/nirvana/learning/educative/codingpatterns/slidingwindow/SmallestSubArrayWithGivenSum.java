package com.nirvana.learning.educative.codingpatterns.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0, if no such subarray exists.
 */
public class SmallestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int result = SmallestSubArrayWithGivenSum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubArrayWithGivenSum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubArrayWithGivenSum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        System.out.println("Smallest subarray length: " + result);
    }

    //O(N)
    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0;
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd + 1 - windowStart);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
