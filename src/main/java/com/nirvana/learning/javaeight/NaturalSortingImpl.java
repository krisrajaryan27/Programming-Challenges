package com.nirvana.learning.javaeight;


import java.util.Arrays;

/**
 * Sorting an array with natural order.
 */
public class NaturalSortingImpl {
    public static void main(String[] args) {
        int[] number = {-3, -5, 1, 7, 4, -2};
        Arrays.sort(number);
        System.out.println("Sorted integer array in natural order");
        Arrays.stream(number).forEach(value -> System.out.print(value + " "));

        //String class implements the Comparable interface, so the sorting works as you would expect.
        String[] strings = {"z", "x", "y", "abc", "zzz", "zazzy"};
        Arrays.sort(strings);
        System.out.println("Sorted string array in natural order");
        Arrays.stream(strings).forEach(value -> System.out.print(value + " "));

    }
}
