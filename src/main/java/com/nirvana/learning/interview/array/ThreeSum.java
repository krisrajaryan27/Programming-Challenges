package com.nirvana.learning.interview.array;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        System.out.println(threeSumM2(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null && nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums); //Sort numbers from low to high to move the pointers later.
        //-4,-1,-1,0,1,2
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) { // Break as sum cannot be 0 since nums[i] > 0 already.
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { // Skip duplicates
                continue;
            }
            //Similar to two sum, we are to find 2 numbers that sum to a target, -nums[i]
            int j = i + 1; // Start from after i
            int k = nums.length - 1; // Ends at the end of the array.
            while (j < k) {
                if (nums[i] + nums[j] > 0) { // Break. Already > 0
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) { // Skip duplicates
                    j++;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else { // Sum is 0
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; // Update the pointers
                    k--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumM2(int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }
}
