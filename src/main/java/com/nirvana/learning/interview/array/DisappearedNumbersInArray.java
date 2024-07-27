package com.nirvana.learning.interview.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p>
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * <p>
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * **/
public class DisappearedNumbersInArray {
    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums1)); // Output: [5, 6]
        System.out.println(findDisappearedNumbersOptimised(nums1)); // Output: [5, 6]

        int[] nums2 = {1, 1};
        System.out.println(findDisappearedNumbers(nums2)); // Output: [2]
        System.out.println(findDisappearedNumbersOptimised(nums2)); // Output: [2]

        int[] nums3 = {4, -3, 2, 7, 8, -2, -3, 1};
        System.out.println(findDisappearedNumbers(nums3)); // Output: [5, 6]
        System.out.println(findDisappearedNumbersOptimised(nums3)); // Output: [5, 6]
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i + 1)) result.add(i + 1);
        }
        return result;
    } //TC: O(NlogN), SC: O(N)

    // A Java method to find disappeared numbers in an array efficiently using marking and collecting steps.
    public static List<Integer> findDisappearedNumbersOptimised(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        // Step 1: Mark the presence of each number
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Use absolute value to find the correct index
            if (nums[index] > 0) { // Only negate if the value is positive
                nums[index] = -nums[index]; // Negate the value at the index
            }
        }

        // Step 2: Collect the missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { // If the value is still positive, the index + 1 is
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    } //TC: O(N), SC: O(1)
}
