package com.nirvana.learning.interview.array;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedLists {
    public static void main(String[] args) {
        // Test cases
        int[] list1 = {1, 2, 3, 4, 5};
        int[] list2 = {2, 4, 6, 8};
        System.out.println(findIntersection(list1, list2)); // Output: [2, 4]

        int[] list3 = {1, 3, 4, 7, 9};
        int[] list4 = {1, 2, 4, 5, 9};
        System.out.println(findIntersection(list3, list4)); // Output: [1, 4, 9]

        int[] list5 = {5, 6, 7};
        int[] list6 = {1, 2, 3};
        System.out.println(findIntersection(list5, list6)); // Output: []
    }

    public static List<Integer> findIntersection(int[] list1, int[] list2) {
        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.length && j < list2.length) {
            if (list1[i] == list2[j]) {
                intersection.add(list1[i]);
                i++;
                j++;
            } else if (list1[i] < list2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return intersection;
    }
}
