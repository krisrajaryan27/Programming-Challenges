package com.nirvana.learning.educative.codingpatterns.slidingwindow;

import java.util.Arrays;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 */
public class AverageOfContiguousSubArraysOfSizeK {
    public static void main(String[] args) {
        double[] result = AverageOfContiguousSubArraysOfSizeK.findAveragesBrute(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));

        double[] optimisedResult = AverageOfContiguousSubArraysOfSizeK.findAveragesOptimised(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Averages of subarrays of size K optimised: " + Arrays.toString(optimisedResult));
    }

    //O(N*K)
    private static double[] findAveragesBrute(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++) {
            // find sum of next 'K' elements
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            result[i] = sum / k;
        }
        return result;
    }

    //O(N)
    public static double[] findAveragesOptimised(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum / K;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return result;
    }
}
