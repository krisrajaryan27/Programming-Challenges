package com.nirvana.learning.educative.datastructures.arrays;

import java.util.Arrays;

public class RightRotateArrayByLastIndex {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotateArray(array);
        rotateArrayM2(array);
        System.out.println(Arrays.toString(array));
    }

    public static void rotateArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }

    //Rotates given Array by 1 position
    public static void rotateArrayM2(int[] arr) {
        //Store last element of Array.
        //Start from the Second last and Right Shift the Array by one.
        //Store the last element saved on the first index of the Array.
        int lastElement = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastElement;
    } //end of rotateArray
}
