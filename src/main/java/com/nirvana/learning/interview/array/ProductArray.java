package com.nirvana.learning.interview.array;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array
 * is the product of all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 **/
public class ProductArray {
    public static void main(String[] args) {
        Arrays.stream(productArray(new int[]{1, 2, 3, 4, 5})).forEach(System.out::println);
    }

    private static int[] productArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return new int[]{0};
        int[] result = new int[len];
        /* Initialize the product array as 1 */
        for (int j = 0; j < len; j++)
            result[j] = 1;
 
        /* In this loop, Prefix variable contains product of
           elements on left side excluding nums[i] */
        // Perform Prefix product operation by traversing Left -> Right
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        Arrays.stream(result).forEach(System.out::println);
        /* In this loop, temp variable contains product of
           elements on right side excluding nums[i] */
        // Perform Postfix product operation by traversing Right -> Left
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
}
