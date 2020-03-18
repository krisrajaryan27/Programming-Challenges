package com.nirvana.learning.educative.datastructures.arrays;

import java.util.Arrays;

public class RearrangeArrayPositiveNegative {
    public static void main(String[] args) {
        int[] arr = {10, -1, 20, 4, 5, -9, -6};
        reArrange(arr);
        reArrangeOptimised(arr);


    }

    public static void reArrange(int[] arr) {
        int[] result = new int[arr.length];
        int count = 0;
        for (int value : arr) {
            if (value < 0) {
                result[count++] = value;
            }
        }

        for (int value : arr) {
            if (value > 0) {
                result[count++] = value;
            }
        }
        System.out.println(Arrays.toString(result));
    }

    //Re-Arrange Positive and Negative Values of Given Array
    public static void reArrangeOptimised(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {   // if negative number found
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j]; // swapping with leftmost positive
                    arr[j] = temp;
                }
                j++;
            }
        }
    } //end of reArrange()
}
