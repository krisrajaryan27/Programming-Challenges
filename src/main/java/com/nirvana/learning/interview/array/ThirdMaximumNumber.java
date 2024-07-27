package com.nirvana.learning.interview.array;

import java.util.Arrays;

/***
 * Given an integer array nums, return the third distinct maximum number in this array.
 * If the third maximum does not exist, return the maximum number.
 * Example 1:
 * <p>
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * Example 2:
 * <p>
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * <p>
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * Follow up: Can you find an O(n) solution?
 * **/
public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        // Sort the array in descending order
        Arrays.sort(nums);

        // To find the distinct maximums, we can iterate from the end
        int distinctCount = 0;
        int lastSeen = Integer.MIN_VALUE; // Initialize to the smallest possible integer

        // Iterate from the end of the sorted array
        for (int i = nums.length - 1; i >= 0; i--) {
            // Only count distinct values
            if (nums[i] != lastSeen) {
                distinctCount++;
                lastSeen = nums[i]; // Update last seen value
            }
            // If we have found the third distinct maximum, return it
            if (distinctCount == 3) {
                return nums[i];
            }
        }

        // If less than three distinct numbers, return the maximum
        return nums[nums.length - 1]; // The last element is the maximum
    } //TC: O(NlogN), SC: O(1)

    public static int thirdMaxOptimised(int[] nums) {
        // Initialize variables to hold the first, second, and third maximums
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        // Iterate through the array
        for (int num : nums) {
            // Update the maximums
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (first > num && num > second) {
                third = second;
                second = num;
            } else if (second > num && num > third) {
                third = num;
            }

        }
        return third != Long.MIN_VALUE ? (int) third : (int) first;
    } //TC: O(N), SC: O(1)

    public static void main(String[] args) {
        // Example usage
        int[] nums1 = {3, 2, 1};
        System.out.println(thirdMax(nums1)); // Output: 1
        System.out.println(thirdMaxOptimised(nums1)); // Output: 1

        int[] nums2 = {1, 2};
        System.out.println(thirdMax(nums2)); // Output: 2
        System.out.println(thirdMaxOptimised(nums2)); // Output: 2

        int[] nums3 = {2, 2, 3, 1};
        System.out.println(thirdMax(nums3)); // Output: 1
        System.out.println(thirdMaxOptimised(nums3)); // Output: 1

    }
}
