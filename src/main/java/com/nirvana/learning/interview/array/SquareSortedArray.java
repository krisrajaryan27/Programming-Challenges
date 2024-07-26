package com.nirvana.learning.interview.array;

import java.util.Arrays;

/***
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * Follow up: Squaring each element and sorting the new array is very trivial,
 * could you find an O(n) solution using a different approach?
 * **/
public class SquareSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] result1 = sortedSquares(nums1);
        System.out.println(Arrays.toString(result1)); // Output: [0, 1, 9, 16, 100]

        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] result2 = sortedSquares(nums2);
        System.out.println(Arrays.toString(result2)); // Output: [4, 9, 9, 49, 121]
    }

    private static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] result = new int[length]; // Result array to hold the squares
        int left = 0; // Pointer at the start
        int right = length - 1; // Pointer at the end
        int index = length - 1; // Position to fill in the result array
        while (left <= right) {
            int leftSquare = nums[left] * nums[left]; // Square of the left pointer
            int rightSquare = nums[right] * nums[right]; // Square of the right pointer
            if (leftSquare > rightSquare) {
                result[index] = leftSquare; // Place left square in the result
                left++; // Move left pointer to the right
            } else {
                result[index] = rightSquare; // Place right square in the result
                right--; // Move right pointer to the left
            }
            index--; // Move to the next position in the result array
        }
        return result; // Return the sorted squares
    }

}
