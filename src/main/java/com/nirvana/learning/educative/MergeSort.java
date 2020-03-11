package com.nirvana.learning.educative;

import java.util.Random;

public class MergeSort {
    static int SIZE = 5000;
    static Random random = new Random(System.currentTimeMillis());
    static int[] input = new int[SIZE];
    static int[] scratch = new int[SIZE];

    public static void main(String[] args) {
        createTestData();
        long start = System.currentTimeMillis();
        mergeSort(0, input.length - 1, input);
        long end = System.currentTimeMillis();
        System.out.println("Time taken = " + (end - start));
    }

    static void mergeSort(int start, int end, int[] input) {

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        // sort first half
        mergeSort(start, mid, input);

        // sort second half
        mergeSort(mid + 1, end, input);

        // merge the two sorted arrays
        int i = start;
        int j = mid + 1;
        int k;

        for (k = start; k <= end; k++) {
            scratch[k] = input[k];
        }
        k = start;
        while (k <= end) {

            if (i <= mid && j <= end) {
                input[k] = Math.min(scratch[i], scratch[j]);

                if (input[k] == scratch[i]) {
                    i++;
                } else {
                    j++;
                }
            } else if (i <= mid && j > end) {
                input[k] = scratch[i];
                i++;
            } else {
                input[k] = scratch[j];
                j++;
            }
            k++;
        }
    }

    static void createTestData() {
        for (int i = 0; i < SIZE; i++) {
            input[i] = random.nextInt(1000);
        }
    }
}
