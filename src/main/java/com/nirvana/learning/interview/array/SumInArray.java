package com.nirvana.learning.interview.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * <p>
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17
 */
public class SumInArray {
    public static void main(String[] args) {
        int[] nums = {10, 15, 3, 7};
        int k = 17;
        System.out.println(isAdditionPossible(nums, k));
    }

    private static boolean isAdditionPossible(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int difference = Math.abs(num - k);
            if (set.contains(difference)) return true;
            set.add(num);
        }
        return false;
    }
}
