package com.nirvana.learning.interview.array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayAndCreateNewArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] result1 = copyWithRemovedDuplicates(nums1);
        System.out.println(Arrays.toString(result1));
        // Expected nums: [1, 2, _]

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] result2 = copyWithRemovedDuplicates(nums2);
        System.out.println(Arrays.toString(result2));
    }

    public static int[] copyWithRemovedDuplicates(int[] nums) {
        // Check for edge cases.
        if (nums == null || nums.length == 0) return nums;

        // Count how many unique elements are in the Array.
        int uniqueNumbers = 0;
        for (int i = 0; i < nums.length; i++) {
            // An element should be counted as unique if it's the first
            // element in the Array, or is different to the one before it.
            if (i == 0 || nums[i] != nums[i - 1]) {
                uniqueNumbers++;
            }
        }

        // Create a result Array.
        int[] result = new int[uniqueNumbers];

        int positionInResult = 0;
        for (int i = 0; i < nums.length; i++) {
            // Same condition as in the previous loop. Except this time, we can write
            // each unique number into the result Array instead of just counting them.
            if (i == 0 || nums[i] != nums[i - 1]) {
                result[positionInResult] = nums[i];
                positionInResult++;
            }
        }
        return result;
    }
}
