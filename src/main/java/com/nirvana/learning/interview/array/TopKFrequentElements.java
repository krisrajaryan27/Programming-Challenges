package com.nirvana.learning.interview.array;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * <p>
 * -104 <= nums[i] <= 104
 * <p>
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * <p>
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * <a href="https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/">Leetcode</a>
 **/
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();

        for (int n : nums) {
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
        }

        // Step 2: Use a min-heap to keep track of the top k elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        // go through all numbers of map & push them in a minHeap which will have top k elements
        // If at any time it has > K elements, then remove the smallest element.

        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Let's create a list of top k elements and Extract the elements from the min-heap
        List<Integer> topKNumbers = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            topKNumbers.add(minHeap.poll().getKey());
        }
        return topKNumbers.stream().mapToInt(i -> i).toArray();
    } //TC: O(N + KlogK) , SC: O(N)
}
