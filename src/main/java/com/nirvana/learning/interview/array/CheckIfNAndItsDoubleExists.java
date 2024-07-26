package com.nirvana.learning.interview.array;

import java.util.HashSet;
import java.util.Set;

/***
 * Given an array arr of integers, check if there exist two indices i and j such that :
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * Example 1:
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 * Example 2:
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: There is no i and j that satisfy the conditions.
 * Constraints:
 * 2 <= arr.length <= 500
 * -103 <= arr[i] <= 103
 * <a href="https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250">...</a>
 * **/
public class CheckIfNAndItsDoubleExists {
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            // Check if double of the current number exists in the set
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true; // Found the condition
            }
            // Add the current number to the set
            set.add(num);
        }

        return false; // No such indices found
    } //TC: O(nlogn) SC: O(n)

    public static boolean checkIfExistBrute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == 2 * arr[j]) return true;
            }
        }
        return false;
    } //TC: O(n^2) SC: O(1)


    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {10, 2, 5, 3};
        System.out.println(checkIfExistBrute(arr1)); // Output: true
        System.out.println(checkIfExist(arr1)); // Output: true

        int[] arr2 = {7, 1, 14, 11};
        System.out.println(checkIfExistBrute(arr2)); // Output: true
        System.out.println(checkIfExist(arr2)); // Output: true

        int[] arr3 = {3, 1, 7, 11};
        System.out.println(checkIfExistBrute(arr3)); // Output: false
        System.out.println(checkIfExist(arr3)); // Output: false
    }
}
