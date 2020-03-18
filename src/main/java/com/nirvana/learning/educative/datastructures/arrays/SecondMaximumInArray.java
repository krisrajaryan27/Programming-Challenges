package com.nirvana.learning.educative.datastructures.arrays;

public class SecondMaximumInArray {
    public static void main(String[] args) {
        int[] array = {-2, -33, -10, -456};
        System.out.println(findSecondMaximumM1(array));
        System.out.println(findSecondMaximumM2(array));
    }

    public static int findSecondMaximumM1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;

        // Find the maximum value in the array by comparing each index with max
        // If an element is greater than max then update max to be equal to it
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];

        }//end of for-loop

        // Find the second maximum value by comparing each index with secondmax
        // If an element is greater than secondmax and not equal to previously
        // calculated max, then update secondmax to be equal to that element.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondmax && arr[i] != max)
                secondmax = arr[i];

        }//end of for-loop

        return secondmax;
    }


    public static int findSecondMaximumM2(int[] arr) {

        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;

        // Keep track of Maximum value, whenever the value at an array index is greater
        // than current Maximum value then make that max value 2nd max value and
        // make that index value maximum value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondmax = max;
                max = arr[i];
            } else if (arr[i] > secondmax && arr[i] != max) {
                secondmax = arr[i];
            }
        }//end of for-loop

        return secondmax;
    } //end of findSecondMaximum
}
