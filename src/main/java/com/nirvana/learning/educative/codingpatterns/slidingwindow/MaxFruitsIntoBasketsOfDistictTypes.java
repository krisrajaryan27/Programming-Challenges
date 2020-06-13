package com.nirvana.learning.educative.codingpatterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets and your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.
 */

//Similar Problem - Longest Substring with Atmost two distinct characters
public class MaxFruitsIntoBasketsOfDistictTypes {
    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitsIntoBasketsOfDistictTypes.findMaxFruitsInBaskets(new char[]{'A', 'B', 'C', 'A', 'C'}, 2));
        System.out.println("Maximum number of fruits: " +
                MaxFruitsIntoBasketsOfDistictTypes.findMaxFruitsInBaskets(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}, 2));
    }

    //O(N)
    public static int findMaxFruitsInBaskets(char[] arr, int baskets) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
            // shrink the sliding window, until we are left with '2' fruits in the frequency map
            while (fruitFrequencyMap.size() > baskets) {
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

}
