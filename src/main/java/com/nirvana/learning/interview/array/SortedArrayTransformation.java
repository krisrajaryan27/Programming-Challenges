package com.nirvana.learning.interview.array;

/**
 * Date 10/08/2019
 *
 * @author Krishna Verma
 * <p>
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 * <p>
 * Time complexity O(n)
 * <p>
 * https://leetcode.com/problems/sort-transformed-array/
 */
public class SortedArrayTransformation {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];
        int index = (a >= 0 ? nums.length - 1 : 0);
        while (start <= end) {
            int x = apply(nums[start], a, b, c);
            int y = apply(nums[end], a, b, c);
            boolean condition = (a >= 0 ? x >= y : x <= y);
            if (condition) {
                result[index] = x;
                start++;
            } else {
                result[index] = y;
                end--;
            }
            index = index + (a >= 0 ? -1 : 1);
        }
        return result;
    }

    private int apply(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
