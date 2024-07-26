package com.nirvana.learning.interview.array;

import java.util.Arrays;

/***
 * Given an array arr, replace every element in that array with the greatest element
 * among the elements to its right, and replace the last element with -1.
 * After doing so, return the array.
 * Example 1:
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 * Example 2:
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 * Constraints:
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 105
 * **/
public class ReplaceElementWIthGreatestElementInRight {
    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] arr1 = {56903, 18666, 60499, 57517, 26961};
        System.out.println(Arrays.toString(replaceElements(arr)));
        System.out.println(Arrays.toString(replaceElements(arr1)));

        int[] arr3 = {400};
        int[] result2 = replaceElements(arr3);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [-1]
    }

    private static int[] replaceElements(int[] arr) {
        int length = arr.length;
        int maxFromRight = -1; // Initialize max as -1 for the last element
        // Iterate from the end to the beginning
        for (int i = length - 1; i >= 0; i--) {
            int current = arr[i]; // Store the current value
            arr[i] = maxFromRight; // Replace current element with max from right
            maxFromRight = Math.max(maxFromRight, current); // Update maxFromRight
        }
        return arr;
    } //TC: O(N), SC: O(1)
}
