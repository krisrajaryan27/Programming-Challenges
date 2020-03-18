package com.nirvana.learning.educative.recursion.arrays;

public class ReplaceNegativeToZero {
    private static void replaceNegativeValuesRecursive(int[] arr, int currentIndex) {
        if (arr.length == currentIndex) {
            return;
        }
        if (arr[currentIndex] < 0) {
            arr[currentIndex] = 0;
        }
        System.out.print(arr[currentIndex] + " ");
        replaceNegativeValuesRecursive(arr, currentIndex + 1);
    }

    private static void replaceNegativeValuesIterative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }

    }


    public static void main(String[] args) {
        System.out.println("Before: ");
        int[] array = {2, -3, 4, -1, -7, 8, 3};
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("} ");
        System.out.println("After Recursively: ");
        System.out.print("{ ");
        replaceNegativeValuesRecursive(array, 0);
        System.out.println("} ");

        System.out.println("After Iteratively: ");
        System.out.print("{ ");
        replaceNegativeValuesIterative(array);
        System.out.println("} ");
    }
}
