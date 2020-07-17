package com.nirvana.learning.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Date 07/31/2019
 *
 * @author Krishna Verma
 * <p>
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Time complexity O(n^3)
 * Space complexity O(1)
 * <p>
 * Reference
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 5, 9, 11};
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target = 0;
        FourSum fourSum = new FourSum();
        List<List<Integer>> result = fourSum.fourSum(nums1, target);
        result.forEach(System.out::print);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) { // 3 indices remain
            if (i != 0 && nums[i] == nums[i - 1]) { // Skip duplicates
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) { // Already greater than the target
                break;
            }
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) { // Skip this index i as sum < target
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) { // 2 indices remain
                if (j != i + 1 && nums[j] == nums[j - 1]) { // Skip duplicates
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) { // Already greater than the target
                    break;
                }
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) { // Skip this index j as sum < target
                    continue;
                }
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (low != j + 1 && nums[low] == nums[low - 1]) { // Skip duplicates
                        low++;
                        continue;
                    }
                    if (high != nums.length - 1 && nums[high] == nums[high + 1]) { // Skip duplicates
                        high--;
                        continue;
                    }

                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum < target) {
                        low++;
                    } else if (sum > target) {
                        high--;
                    } else { // sum == target
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                    }
                }
            }
        }
        return result;
    }
}
