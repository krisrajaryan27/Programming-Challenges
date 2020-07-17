package com.nirvana.learning.interview.array;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums
 * such that the sum is closest to target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Constraints:
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
        System.out.println(threeSumClosestM2(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closest = 0;
        if (nums == null) { // Handle null input array
            return closest;
        }
        Arrays.sort(nums);
        // Get first sum
        for (int i = 0; i < nums.length && i < 3; i++) {
            closest += nums[i];
        }
        if (nums.length < 3) { // Handle arrays with < 3 numbers
            return closest;
        }
        // Search for closet sum with 2 pointers
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum; // Current sum is even closer
                    if (closest == target) return closest; // sum is exactly target
                }
                if (sum > target) high--;
                else low++;
            }
            // Done with num[i]
        }
        return closest;
    }

    public static int threeSumClosestM2(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int currentSum = nums[i] + nums[low] + nums[high];
                if (currentSum > target) {
                    high--;
                } else {
                    low++;
                }
                if (Math.abs(currentSum - target) < Math.abs(result - target)) {
                    result = currentSum;
                }
            }
        }
        return result;

    }
}
