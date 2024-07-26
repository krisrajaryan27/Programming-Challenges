package com.nirvana.learning.interview.array;

/***
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * Example 1:
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * Example 2:
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 * **/
public class EvenLengthNumbers {
    public static int countNumbersWithEvenDigits(int[] nums) {
        int count = 0; // Counter for numbers with even digits

        for (int num : nums) {
            // Calculate the number of digits in the number
            int digitCount = String.valueOf(Math.abs(num)).length(); // Use abs to handle negative numbers
            if (digitCount % 2 == 0) { // Check if the digit count is even
                count++;
            }
        }

        return count; // Return the count of numbers with even digits
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {12, 345, 2, 6, 7896};
        System.out.println(countNumbersWithEvenDigits(nums1)); // Output: 2

        int[] nums2 = {555, 901, 482, 1771};
        System.out.println(countNumbersWithEvenDigits(nums2)); // Output: 1

        int[] nums3 = {1, 22, 333, 4444, 55555};
        System.out.println(countNumbersWithEvenDigits(nums3)); // Output: 2
    }
}
