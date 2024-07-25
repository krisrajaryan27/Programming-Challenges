package com.nirvana.learning.interview.array;

/***
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * **/
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0; // To keep track of the maximum count of consecutive 1's
        int consecutiveOnes = 0; // To keep track of the current count of consecutive 1's

        for (int num : nums) {
            if (num == 1) {
                consecutiveOnes = consecutiveOnes + 1; // Increment count for 1
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, consecutiveOnes); // Update max if needed
            } else {
                consecutiveOnes = 0; // Reset count for 0
            }
        }
        return maxConsecutiveOnes; // Return the maximum count found
    }


    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }
}
