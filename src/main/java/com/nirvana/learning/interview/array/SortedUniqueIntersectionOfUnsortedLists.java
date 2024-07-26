package com.nirvana.learning.interview.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortedUniqueIntersectionOfUnsortedLists {
    public static void main(String[] args) {
        // Test cases
        int[] list1 = {4, 1, 2, 3, 2, 3};
        int[] list2 = {2, 4, 6, 4, 2, 8};
        System.out.println(findIntersection(list1, list2)); // Output: [2, 4]

        int[] list3 = {1, 3, 4, 7, 9, 3};
        int[] list4 = {1, 2, 4, 5, 9, 9};
        System.out.println(findIntersection(list3, list4)); // Output: [1, 4, 9]

        int[] list5 = {5, 6, 7, 7};
        int[] list6 = {1, 2, 3, 3};
        System.out.println(findIntersection(list5, list6)); // Output: []
    }

    public static List<Integer> findIntersection(int[] list1, int[] list2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : list1) {
            set1.add(num);
        }

        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : list2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }
        List<Integer> intersectionList = new ArrayList<>(intersectionSet);
        intersectionList.sort(Integer::compareTo);
        return intersectionList;
    }
}
