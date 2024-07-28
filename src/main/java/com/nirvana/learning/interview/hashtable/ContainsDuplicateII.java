package com.nirvana.learning.interview.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true
 * if there are two distinct indices i and j in the array
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * <p>
 * -109 <= nums[i] <= 109
 * <p>
 * 0 <= k <= 105
 */
public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                // Check the distance between the current index and the stored index
                if (i - indexMap.get(nums[i]) <= k) {
                    return true; // Found a valid pair
                }
            }
            // Update the index of the current number
            indexMap.put(nums[i], i);
        }

        return false; // No valid pairs found
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1) + ", k = " + k1 + ", Output: " + containsNearbyDuplicate(nums1, k1)); // Output: true

        // Example 2
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2) + ", k = " + k2 + ", Output: " + containsNearbyDuplicate(nums2, k2)); // Output: true

        // Example 3
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums3) + ", k = " + k3 + ", Output: " + containsNearbyDuplicate(nums3, k3)); // Output: false
    }
}
