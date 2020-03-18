package com.nirvana.learning.educative.recursion.arrays;

public class ReverseArray {
    public static void main(String[] args) {
        System.out.println("Before: ");
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("} ");
        System.out.println("After: ");
        reverseArray(array, 0);
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("} ");
    }

    private static void reverseArray(int[] array, int index) {
        int length = array.length;
        int swap_index = length - 1 - index;
        if (index < length / 2) {
            int temp = array[index];
            array[index] = array[swap_index];
            array[swap_index] = temp;
            reverseArray(array, index + 1);
        }
    }

    private static void invertIteratively(int[] arr) {
        int s = arr.length / 2;
        int tmp = arr.length - 1;
        int tmp2 = 0;
        for (int i = 0; i < s; i++) {
            tmp2 = arr[i];
            arr[i] = arr[tmp];
            arr[tmp] = tmp2;
            tmp = tmp - 1;
        }
    }
}
