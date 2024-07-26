package com.nirvana.learning.interview.array;

import java.util.Arrays;

/**
 * @author KrishnaV
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums1 = {4, 2, 5, 7};
        int[] nums2 = {4, 2, 5, 7};
        int[] nums3 = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParity(nums1)));
        System.out.println(Arrays.toString(sortArrayByParityII(nums2)));
        System.out.println(Arrays.toString(sortArrayByParityIII(nums3)));

    }

    public static int[] sortArrayByParity(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            if (nums[leftIndex] % 2 == 1 && nums[rightIndex] % 2 == 0) {
                int temp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = temp;
            }
            if (nums[leftIndex] % 2 == 0) {
                leftIndex++;
            }
            if (nums[rightIndex] % 2 == 1) {
                rightIndex--;
            }
        }
        return nums;
    } //TC: O(N), SC: O(1)

    public static int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                result[leftIndex++] = num;
            } else {
                result[rightIndex--] = num;
            }
        }

        return result;
    }


    public static int[] sortArrayByParityIII(int[] A) {
        int[] odd = Arrays.stream(A).filter(value -> (value % 2 != 0)).toArray();
        int[] even = Arrays.stream(A).filter(value -> (value % 2 == 0)).toArray();
        int[] result = new int[A.length];
        int counter = 0;
        for (int j : even) {
            result[counter++] = j;
        }

        for (int j : odd) {
            result[counter++] = j;
        }
        return result;
    }
}
