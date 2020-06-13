package com.nirvana.learning.interview.array;

/**
 * Date 12/31//2018
 *
 * @author Krishna Verma
 * <p>
 * Given array in non decreasing order find smallest integer which cannot be represented by
 * subset sum of these integers.
 * <p>
 * Time complexity is O(n)
 * <p>
 * http://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
 */
public class SmallestIntegerNotRepresentedBySubsetSum {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 8};
        SmallestIntegerNotRepresentedBySubsetSum ss = new SmallestIntegerNotRepresentedBySubsetSum();
        System.out.println(ss.findSmallestInteger(input));

        int[] input1 = {};
        System.out.println(ss.minPatches(input1, 7));
    }

    public int findSmallestInteger(int[] input) {
        int result = 1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] <= result) {
                result += input[i];
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Leetcode variation https://leetcode.com/problems/patching-array/
     */
    public int minPatches(int[] nums, int n) {
        int patch = 0;
        long t = 1;
        int i = 0;
        while (t <= n) {
            if (i == nums.length || t < nums[i]) {
                patch++;
                t += t;
            } else {
                t = nums[i] + t;
                i++;
            }
        }
        return patch;
    }
}
