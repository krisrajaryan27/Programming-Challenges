package com.nirvana.learning.interview.hashtable;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<int[]>> pairSumMap = new HashMap<>();
        int n = nums.length;

        // Step 1: Store pairs of sums in the HashMap
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                pairSumMap.putIfAbsent(sum, new ArrayList<>());
                pairSumMap.get(sum).add(new int[]{i, j});
            }
        }

        // Step 2: Find quadruplets
        Set<List<Integer>> uniqueQuadruplets = new HashSet<>();
        for (Map.Entry<Integer, List<int[]>> entry : pairSumMap.entrySet()) {
            int sum = entry.getKey();
            int complement = target - sum;

            if (pairSumMap.containsKey(complement)) {
                List<int[]> list1 = entry.getValue();
                List<int[]> list2 = pairSumMap.get(complement);

                for (int[] pair1 : list1) {
                    for (int[] pair2 : list2) {
                        // Ensure all indices are distinct
                        int a = pair1[0], b = pair1[1];
                        int c = pair2[0], d = pair2[1];
                        if (a != c && a != d && b != c && b != d) {
                            List<Integer> quadruplet = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
                            Collections.sort(quadruplet); // Sort to avoid duplicates
                            uniqueQuadruplets.add(quadruplet);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(uniqueQuadruplets);
    } //TC: O(N^2) SC: O(N^2)

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        System.out.println("Example 1 Output: " + fourSum(nums1, target1));

        // Example 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println("Example 2 Output: " + fourSum(nums2, target2));

        int[] nums3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90};
        int target3 = 200;
        System.out.println("Example 3 Output: " + fourSum(nums3, target3));
    }
}
