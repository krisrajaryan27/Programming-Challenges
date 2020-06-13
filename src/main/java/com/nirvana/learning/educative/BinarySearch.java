package com.nirvana.learning.educative;

import java.util.List;

/**
 * Binary Search is applied on Sorted Lists. Initial ArrayList size is 10.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 4, 6, 7, 101, 1009};
        System.out.println(binarySearchRecursive(0, input.length - 1, 1009, input));
        System.out.println(binarySearchRecursive(0, input.length - 1, -1009, input));
        System.out.println(binarySearchRecursive(0, input.length - 1, 5, input));
        System.out.println(binarySearchRecursive(0, input.length - 1, 6, input));
    }

    /**
     * start and end are inclusive indices
     *
     * @param start
     * @param end
     * @param target
     * @param input
     * @return boolean value
     */
    public static boolean binarySearchRecursive(int start, int end, int target, int[] input) {

        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;

        if (input[mid] == target) {
            return true;
        } else if (input[mid] > target) {
            return binarySearchRecursive(start, mid - 1, target, input);
        } else {
            return binarySearchRecursive(mid + 1, end, target, input);
        }
    }

    public static boolean binarySearch(final List<Integer> numbers, final Integer value) {
        if (numbers == null || numbers.isEmpty()) {
            return false;
        }
        final Integer comparison = numbers.get(numbers.size() / 2);
        if (value.equals(comparison)) {
            return true;
        }
        if (value < comparison) {
            return binarySearch(
                    numbers.subList(0, numbers.size() / 2), value);
        } else {
            return binarySearch(numbers.subList(numbers.size() / 2 + 1, numbers.size()), value);
        }
    }
}
