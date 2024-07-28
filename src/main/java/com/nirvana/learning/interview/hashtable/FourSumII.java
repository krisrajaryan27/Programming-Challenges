package com.nirvana.learning.interview.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
 * return the number of tuples (i, j, k, l) such that:
 * <p>
 * 0 <= i, j, k, l < n
 * <p>
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 * <p>
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * n == nums1.length
 * <p>
 * n == nums2.length
 * <p>
 * n == nums3.length
 * <p>
 * n == nums4.length
 * <p>
 * 1 <= n <= 200
 * <p>
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 * <p>
 * <a href="https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1134/">Leetcode</a>
 */
public class FourSumII {
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println("Example 1 Output: " + fourSumCount(nums1, nums2, nums3, nums4)); // Output: 2

        // Example 2
        int[] nums5 = {0};
        int[] nums6 = {0};
        int[] nums7 = {0};
        int[] nums8 = {0};
        System.out.println("Example 2 Output: " + fourSumCount(nums5, nums6, nums7, nums8)); // Output: 1
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int count = 0;
        // Calculate all possible sums of pairs from nums1 and nums2
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        // Calculate all possible sums of pairs from nums3 and nums4
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                // Check if the negation of the sum exists in the map
                count += sumMap.getOrDefault(-sum, 0);
            }
        }
        return count;
    }
}
