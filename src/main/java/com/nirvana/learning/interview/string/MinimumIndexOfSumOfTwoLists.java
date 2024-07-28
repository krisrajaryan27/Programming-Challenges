package com.nirvana.learning.interview.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 * <p>
 * A common string is a string that appeared in both list1 and list2.
 * <p>
 * A common string with the least index sum is a common string such that
 * if it appeared at list1[i] and list2[j] then i + j should be the minimum value among
 * all the other common strings.
 * <p>
 * Return all the common strings with the least index sum. Return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only common string is "Shogun".
 * <p>
 * Example 2:
 * <p>
 * Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
 * Output: ["Shogun"]
 * Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
 * <p>
 * Example 3:
 * <p>
 * Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
 * Output: ["sad","happy"]
 * Explanation: There are three common strings:
 * "happy" with index sum = (0 + 1) = 1.
 * "sad" with index sum = (1 + 0) = 1.
 * "good" with index sum = (2 + 2) = 4.
 * The strings with the least index sum are "sad" and "happy".
 * <p>
 * Constraints:
 * <p>
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] and list2[i] consist of spaces ' ' and English letters.
 * All the strings of list1 are unique.
 * All the strings of list2 are unique.
 * There is at least a common string between list1 and list2.
 */
public class MinimumIndexOfSumOfTwoLists {
    public static List<String> findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        // Store the indices of strings in list1
        for (int i = 0; i < list1.length; i++) {
            indexMap.put(list1[i], i);
        }

        // Iterate through list2 to find common strings and calculate index sums
        for (int j = 0; j < list2.length; j++) {
            String restaurant = list2[j];
            if (indexMap.containsKey(restaurant)) {
                int indexSum = indexMap.get(restaurant) + j;

                // If we found a new minimum index sum
                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    result.clear(); // Clear previous results
                    result.add(restaurant); // Add the new common restaurant
                } else if (indexSum == minIndexSum) {
                    result.add(restaurant); // Add to the result list
                }
            }
        }

        return result; // Return all common strings with the least index sum
    }

    public static void main(String[] args) {
        // Example 1
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println("Output: " + findRestaurant(list1, list2)); // Output: ["Shogun"]

        // Example 2
        String[] list3 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list4 = {"KFC", "Shogun", "Burger King"};
        System.out.println("Output: " + findRestaurant(list3, list4)); // Output: ["Shogun"]

        // Example 3
        String[] list5 = {"happy", "sad", "good"};
        String[] list6 = {"sad", "happy", "good"};
        System.out.println("Output: " + findRestaurant(list5, list6)); // Output: ["sad", "happy"]
    }
}
