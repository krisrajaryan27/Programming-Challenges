package com.nirvana.learning.educative;

public class InsertionSort {
    static void insertionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > key) {
                if (input[j] > key) {
                    int tmp = input[j];
                    input[j] = key;
                    input[j + 1] = tmp;
                    j--;
                }
            }
        }
    }

    static void printArray(int[] input) {
        System.out.println();
        for (int value : input) System.out.print(" " + value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = new int[]{7, 6, 5, 4, 3, 2, 1};
        insertionSort(input);
        printArray(input);
    }
}
