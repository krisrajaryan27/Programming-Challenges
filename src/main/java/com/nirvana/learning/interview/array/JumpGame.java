package com.nirvana.learning.interview.array;

/**
 * Date 07/31/2019
 *
 * @author Krishna Verma
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * Time complexity O(n)
 * Space complexity O(1)
 * <p>
 * https://leetcode.com/problems/jump-game/
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Time complexity O(n)
 * Space complexity O(1)
 * <p>
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame {

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums = {3, 2, 3, 0, 2, 1};
        System.out.println(jumpGame.jump(nums));
        int[] nums1 = {3, 0, 2, 0, 0, 1};
        System.out.println(jumpGame.canJump(nums1));
    }

    public boolean canJump(int[] nums) {
        int jump = 0;
        int i;
        for (i = 0; i < nums.length && i <= jump; i++) {
            jump = Math.max(jump, i + nums[i]);
        }
        return i == nums.length;
    }

    public int jump(int[] nums) {
        int current = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (current == i) {
                count++;
                current = max;
            }
        }
        return count;
    }
}
