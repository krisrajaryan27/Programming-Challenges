package com.nirvana.learning.interview.array;

/***
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * Recall that arr is a mountain array if and only if:
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 * Constraints:
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 * <a href="https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/">...</a>
 * **/
public class ValidMountainArray {
    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {2, 1}; // false
        int[] arr2 = {3, 5, 5}; // false
        int[] arr3 = {0, 3, 2, 1}; // true
        int[] arr4 = {0, 2, 3, 4, 5, 2, 1, 0}; // true
        int[] arr5 = {1, 2, 3}; // false

        System.out.println(validMountainArray(arr1)); // Output: false
        System.out.println(validMountainArray(arr2)); // Output: false
        System.out.println(validMountainArray(arr3)); // Output: true
        System.out.println(validMountainArray(arr4)); // Output: true
        System.out.println(validMountainArray(arr5)); // Output: false
    }

    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;

        // Step 1: Check if the length is at least 3
        if (n < 3) return false;

        int i = 0;

        // Step 2: Climb up
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        // Check if we reached the peak and it's not the first or last element
        if (i == 0 || i == n - 1) return false;

        // Step 3: Climb down
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        // If we reached the end, it's a valid mountain array
        return i == n - 1;
    }
}
