package com.nirvana.learning.interview.array;

import java.util.*;

public class SortedIntersectionOfUnsortedLists {
    public static void main(String[] args) {
        // Test cases
        int[] list1 = {1, 2, 3, 4, 5, 2};
        int[] list2 = {2, 4, 6, 2, 8, 4};
        System.out.println(findIntersection(list1, list2)); // Output: [2, 2, 4]

        int[] list3 = {1, 3, 4, 7, 9, 3};
        int[] list4 = {1, 2, 4, 5, 9, 9};
        System.out.println(findIntersection(list3, list4)); // Output: [1, 4, 9]

        int[] list5 = {5, 6, 7, 5, 5};
        int[] list6 = {1, 2, 3, 5, 5};
        System.out.println(findIntersection(list5, list6)); // Output: [5, 5]
    }

    public static List<Integer> findIntersection(int[] list1, int[] list2) {
        Map<Integer, Integer> countMap1 = new HashMap<>();
        Map<Integer, Integer> countMap2 = new HashMap<>();
        for (int num : list1) {
            countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
        }
        for (int num : list2) {
            countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : countMap1.keySet()) {
            if (countMap2.containsKey(num)) {
                int minCount = Math.min(countMap1.get(num), countMap2.get(num));
                for (int i = 0; i < minCount; i++) {
                    intersection.add(num);
                }
            }
        }
        Collections.sort(intersection);

        return intersection;
    }
}
