package com.nirvana.learning.interview.bits;

/***
 * Given a non-empty array of integers nums,
 * every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * <p>
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 * **/
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1, 222, 222, 1, 4, 27, 4};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int singleValue = 0;
        for (int num : nums) {
            singleValue = singleValue ^ num;
        }
        return singleValue;
    }
}
