package com.nirvana.learning.interview.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Date 03/03/2019
 *
 * @author Krishna Verma
 * <p>
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * <p>
 * Time complexity O(nlogn)
 * Space complexity O(n)
 * <p>
 * Performance can be improved by using self balancing BST which keeps the count of key and size of substree under it
 * <p>
 * https://leetcode.com/problems/count-of-range-sum/
 */
public class CountRanges {

    public static void main(String[] args) {
        CountRanges cr = new CountRanges();
        int[] input = {0, 0};
        System.out.print(cr.countRangeSum(input, 0, 0));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        Map<Long, Integer> countMap = new HashMap<>();
        long[] prefixSum = new long[nums.length + 1];
        map.put(0l, 1);
        countMap.put(0l, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            NavigableMap<Long, Integer> rangeMap = map.subMap(prefixSum[i + 1] - upper, true, prefixSum[i + 1] - lower, true);
            if (rangeMap.size() > 0) {
                for (int c : rangeMap.values()) {
                    count += c;
                }
            }
            if (countMap.containsKey(prefixSum[i + 1])) {
                countMap.put(prefixSum[i + 1], countMap.get(prefixSum[i + 1]) + 1);
            } else {
                countMap.put(prefixSum[i + 1], 1);
            }

            map.put(prefixSum[i + 1], countMap.get(prefixSum[i + 1]));
        }
        return count;
    }

}

