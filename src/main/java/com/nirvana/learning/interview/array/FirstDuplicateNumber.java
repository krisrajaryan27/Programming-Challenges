package com.nirvana.learning.interview.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array a that contains only numbers in the range from 1 to a.length,
 * find the first duplicate number for which the second occurrence has the minimal index.
 * In other words, if there are more than 1 duplicated numbers, return the number for which the second occurrence has
 * a smaller index than the second occurrence of the other number does. If there are no such elements, return -1.
 * Example
 * For a = [2, 1, 3, 5, 3, 2], the output should be firstDuplicate(a) = 3.
 * There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a smaller index
 * than the second occurrence of 2 does, so the answer is 3.
 * <p>
 * For a = [2, 2], the output should be firstDuplicate(a) = 2;
 * For a = [2, 4, 3, 5, 1], the output should be firstDuplicate(a) = -1.
 * Input/Output
 * The element in a that occurs in the array more than once and has the minimal index for its second occurrence.
 * If there are no such elements, return -1.
 */
public class FirstDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 5, 3, 2};
        System.out.println(firstDuplicate(arr));
        System.out.println(firstDuplicateOptimised(arr));
    }

    private static int firstDuplicate(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (!set.add(a[i])) {
                return a[i];
            }
        }
        return -1;
    }

    private static int firstDuplicateOptimised(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[Math.abs(a[i]) - 1] < 0) {
                return Math.abs(a[i]);
            } else {
                a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
            }
        }
        return -1;
    }


}
