package com.nirvana.learning.interview.array;

import java.util.HashSet;
import java.util.Set;

/***
 * Find Intersection
 * Have the function FindIntersection(strArr) read the array of strings stored in strArr
 * which will contain 2 elements: the first element will represent a list of comma-separated numbers
 * sorted in ascending order, the second element will represent a second list of comma-separated
 * numbers (also sorted). Your goal is to return a comma-separated
 * string containing the numbers that occur in elements of strArr in sorted order.
 * If there is no intersection, return the string false.
 * Examples
 * Input: new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}
 * Output: 1,4,13
 * Input: new String[] {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}
 * Output: 1,9,10
 * <a href="https://www.coderbyte.com/editor/Find%20Intersection:Java">...</a>
 * **/
public class FindIntersection {
    public static void main(String[] args) {
        // Test cases
        String[] test1 = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        System.out.println(findIntersection(test1)); // Output: 1,4,13

        String[] test2 = {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"};
        System.out.println(findIntersection(test2)); // Output: 1,9,10

        String[] test3 = {"5, 6, 7", "8, 9, 10"};
        System.out.println(findIntersection(test3)); // Output: false
    }

    private static String findIntersection(String[] strArr) {
        String[] firstList = strArr[0].split(",\\s*");
        String[] secondList = strArr[1].split(",\\s*");
        Set<Integer> set = new HashSet<>();
        for (String num : firstList) {
            set.add(Integer.parseInt(num.trim()));
        }
        StringBuilder intersection = new StringBuilder();
        for (String num : secondList) {
            int number = Integer.parseInt(num.trim());
            if (set.contains(number)) {
                if (intersection.length() > 0) {
                    intersection.append(",");
                }
                intersection.append(number);
            }
        }
        return intersection.length() > 0 ? intersection.toString() : "false";
    }
}
