package com.nirvana.learning.interview.array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayAndCreateNewArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] result1 = copyWithRemovedDuplicates(nums1);
        int[] result2 = removedDuplicatesOptimised(nums1);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        // Expected nums: [1, 2, _]

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] result3 = copyWithRemovedDuplicates(nums2);
        int[] result4 = removedDuplicatesOptimised(nums2);
        System.out.println(Arrays.toString(result3));
        System.out.println(Arrays.toString(result4));
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
    } //TC: O(N), SC: O(N)

    public static int[] removedDuplicatesOptimised(int[] nums) {
        // Check for edge cases.
        if (nums == null || nums.length == 0) return nums;
        // Use the two pointer technique to remove the duplicates in-place.
        // The first element shouldn't be touched; it's already in its correct place.
        int writePointer = 1;
        // Go through each element in the Array.
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            // If the current element we're reading is *different* to the previous
            // element...
            if (nums[readPointer] != nums[readPointer - 1]) {
                // Copy it into the next position at the front, tracked by writePointer.
                nums[writePointer] = nums[readPointer];
                // And we need to now increment writePointer, because the next element
                // should be written one space over.
                writePointer++;
            }
        }
        return nums;
    }
}
