package com.nirvana.learning.educative.codingpatterns.slidingwindow;

import java.util.Arrays;

/**
 * Given an array of integers, return the array of minimum nos. left to each elements
 * Input: {3, 4, 2, 5, 8, 1, 7, 6}
 * Output: {-1,3,-1,2,2,-1,1,1}
 */
public class ArrayOfSmallestValues {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 5, 8, 1, 7, 6};
        Arrays.stream(arrayOfSmallestValues(arr)).forEach(ArrayOfSmallestValues::accept);
        System.out.println();

    }

    private static int[] arrayOfSmallestValues(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[]{-1};
        }
        int[] result = new int[n];
        result[0] = -1;
        int minSoFar = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > minSoFar) {
                result[i] = minSoFar;
            } else {
                result[i] = -1;
            }
            minSoFar = Math.min(minSoFar, arr[i]);
        }
        return result;
    }

    private static void accept(int value) {
        System.out.print(value + " ");
    }
}
