package com.nirvana.learning.interview.array;

import java.util.*;

public class IntersectionOfUnsortedLists {
    public static void main(String[] args) {
        // Test cases
        int[] list1 = {1, 2, 2, 3, 4, 5};
        int[] list2 = {2, 2, 4, 6, 8};
        System.out.println(findIntersection(list1, list2)); // Output: [2, 2, 4]
        System.out.println(Arrays.toString(findIntersectionArrayWithoutDuplicate(list1, list2))); // Output: [2, 2, 4]

        int[] list3 = {1, 3, 4, 7, 9, 9};
        int[] list4 = {1, 2, 4, 5, 9, 9};
        System.out.println(findIntersection(list3, list4)); // Output: [1, 4, 9, 9]
        System.out.println(Arrays.toString(findIntersectionArrayWithoutDuplicate(list3, list4))); // Output: [1, 4, 9, 9]

        int[] list5 = {5, 6, 7, 7};
        int[] list6 = {1, 2, 3, 7};
        System.out.println(findIntersection(list5, list6)); // Output: [7]
        System.out.println(Arrays.toString(findIntersectionArrayWithoutDuplicate(list5, list6))); // Output: [7]
    }

    private static List<Integer> findIntersection(int[] list1, int[] list2) {
        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        // Count occurrences of each number in the first list
        for (int num : list1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // Iterate through the second list and find intersections
        for (int num : list2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                intersection.add(num);
                // Decrease the count in the map to account for duplicates
                countMap.put(num, countMap.get(num) - 1);
            }
        }
        return intersection;
    }

    private static int[] findIntersectionArrayWithoutDuplicate(int[] list1, int[] list2) {
        Set<Integer> intersection = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num : list1) {
            set.add(num);
        }
        // Iterate through the second list and find intersections
        for (int num : list2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
