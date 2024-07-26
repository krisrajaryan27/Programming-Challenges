package com.nirvana.learning.interview.array;

import java.util.Arrays;

/***
 * Given an Array of integers,
 * return an Array where every element at an even-indexed position is squared.
 * Input: array = [9, -2, -9, 11, 56, -12, -3]
 * Output: [81, -2, 81, 11, 3136, -12, 9]
 * Explanation: The numbers at even indexes (0, 2, 4, 6) have been squared,
 * whereas the numbers at odd indexes (1, 3, 5) have been left the same.
 * **/
public class EvenSquare {
    public static void main(String[] args) {
        int[] nums = {9, -2, -9, 11, 56, -12, -3};
        System.out.println(Arrays.toString(evenSquared(nums)));
    }

    private static int[] evenSquared(int[] arr) {
        if (arr == null) return null;
        for (int i = 0; i < arr.length; i += 2) {
            arr[i] *= arr[i];
        }
        return arr;

    }
}
