package com.nirvana.learning.interview.array;

import java.util.Arrays;

public class MoveAllZerosToEnd {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 0, 5, 6, 7, 0};
        int[] arr1 = {0, 0, 1, 2, 0, 5, 6, 7, 0};
        moveZerosBetter(arr);
        moveZeros(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }

    public static void moveZeros(int[] arr) {
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            if (arr[fast] == 0) {
                fast++;
                continue;
            }
            arr[slow] = arr[fast];
            slow++;
            fast++;
        }
        while (slow < arr.length) {
            arr[slow++] = 0;
        }
    }

    public static void moveZerosBetter(int[] arr) {
        int zeros = 0;
        int index = 0;
        for (int num : arr) {
            if (num == 0) {
                zeros++;
            } else {
                arr[index++] = num;
            }
        }
        for (int i = 0; i < zeros; i++) {
            arr[index++] = 0;
        }
    }
}
