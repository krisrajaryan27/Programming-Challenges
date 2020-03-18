package com.nirvana.learning.educative.recursion.arrays;

public class CountOfOccurenceOfNumber {
    private static int noOfOccurrencesRecursive(int[] a, int key, int currentIndex) {
        if (a.length == currentIndex) {
            return 0;
        } else if (a[currentIndex] == key) {
            return 1 + noOfOccurrencesRecursive(a, key, currentIndex + 1);
        } else {
            return noOfOccurrencesRecursive(a, key, currentIndex + 1);
        }
    }

    private static int occurrencesIterative(int[] arr, int n) {
        int tmp = 0;
        for (int value : arr) {
            if (value == n)
                tmp = tmp + 1;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.print("{");

        int[] array = {2, 3, 4, 1, 7, 8, 3};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("}");

        int key = 3;
        int output = noOfOccurrencesRecursive(array, key, 0);
        System.out.println("Number of occurrences of " + key + ": " + output);

        output = occurrencesIterative(array, key);
        System.out.println("Number of occurrences of " + key + ": " + output);
    }
}
