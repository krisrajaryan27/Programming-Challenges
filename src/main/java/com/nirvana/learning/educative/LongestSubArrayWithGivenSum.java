package com.nirvana.learning.educative;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int[] arr1 = {-1, 2, 3};
        System.out.println(lengthOfLongestSubArrayWithGivenSum(arr, 15));
        System.out.println(lengthOfLongestSubArrayWithGivenSum(arr1, 6));
    }

    private static int lengthOfLongestSubArrayWithGivenSum(int[] arr, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        // traverse the given array
        for (int i = 0; i < arr.length; i++) {
            // accumulate sum
            sum += arr[i];
            // when subarray starts from index '0'
            if (sum == K)
                maxLen = i + 1;
            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - K)) {
                // update maxLength
                if (maxLen < (i - map.get(sum - K)))
                    maxLen = i - map.get(sum - K);
            }
        }

        return maxLen;
    }
}
