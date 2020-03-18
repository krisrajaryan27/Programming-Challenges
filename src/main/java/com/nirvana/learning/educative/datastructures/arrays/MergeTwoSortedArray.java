package com.nirvana.learning.educative.datastructures.arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 12, 14, 17, 23}; // creating a sorted array called arr1
        int[] arr2 = {11, 19, 27};  // creating a sorted array called arr2

        int[] resultantArray = mergeArrays(arr1, arr2); // calling mergeArrays

        System.out.print("Arrays after merging: ");
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            System.out.print(resultantArray[i] + " ");
        }
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // merge the two sorted arrays
        int total_len = arr1.length + arr2.length;
        int[] result = new int[total_len];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < total_len) {
            if (i < arr1.length && j < arr2.length) {
                result[k] = Math.min(arr1[i], arr2[j]);
                if (result[k] == arr1[i]) {
                    i++;
                } else {
                    j++;
                }
            } else if (i < arr1.length && j > arr2.length) {
                result[k] = arr1[i++];
            } else {
                result[k] = arr2[j++];
            }
            k++;
        }
        return result;
    }
}
