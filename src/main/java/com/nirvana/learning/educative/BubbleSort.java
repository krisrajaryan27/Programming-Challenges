package com.nirvana.learning.educative;

import java.util.Random;

public class BubbleSort {
    static int SIZE = 10000;
    static Random random = new Random(System.currentTimeMillis());
    static int[] input = new int[SIZE];

    public static void main(String[] args) {
        createTestData();
        long start = System.currentTimeMillis();
        bubbleSort(input);
        long end = System.currentTimeMillis();
        System.out.println("Time taken = " + (end - start));
    }

    static void bubbleSort(int[] input) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int tmp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = tmp;
                }
            }
        }
    }

    static void createTestData() {
        for (int i = 0; i < SIZE; i++) {
            input[i] = random.nextInt(10000);
        }
    }
}
