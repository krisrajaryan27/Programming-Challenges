package com.nirvana.learning.interview.array;

import java.util.Arrays;

/***
 * A school is trying to take an annual photo of all the students.
 * The students are asked to stand in a single file line in non-decreasing order by height.
 * Let this ordering be represented by the integer array expected
 * where expected[i] is the expected height of the ith student in line.
 * <p>
 * You are given an integer array heights representing the current order
 * that the students are standing in. Each heights[i] is the
 * height of the ith student in line (0-indexed).
 * <p>
 * Return the number of indices where heights[i] != expected[i].
 * Example 1:
 * <p>
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * heights:  [1,1,4,2,1,3]
 * expected: [1,1,1,2,3,4]
 * Indices 2, 4, and 5 do not match.
 * Example 2:
 * <p>
 * Input: heights = [5,1,2,3,4]
 * Output: 5
 * Explanation:
 * heights:  [5,1,2,3,4]
 * expected: [1,2,3,4,5]
 * All indices do not match.
 * Example 3:
 * <p>
 * Input: heights = [1,2,3,4,5]
 * Output: 0
 * Explanation:
 * heights:  [1,2,3,4,5]
 * expected: [1,2,3,4,5]
 * All indices match.
 * <p>
 * Constraints:
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * <p>
 * **/
public class HeightChecker {
    public static int heightChecker(int[] heights) {
        // Create a copy of the original array to sort
        int[] expected = heights.clone();

        // Sort the expected array
        Arrays.sort(expected);

        // Count the number of indices where heights[i] != expected[i]
        int mismatchCount = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                mismatchCount++;
            }
        }

        return mismatchCount;
    }

    public static void main(String[] args) {
        // Example usage
        int[] heights1 = {1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(heights1)); // Output: 3

        int[] heights2 = {5, 1, 2, 3, 4};
        System.out.println(heightChecker(heights2)); // Output: 5

        int[] heights3 = {1, 2, 3, 4, 5};
        System.out.println(heightChecker(heights3)); // Output: 0
    }
}
