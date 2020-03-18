package com.nirvana.learning.educative.datastructures.arrays;

import java.util.Arrays;

public class RearrangeSortedArrayMaxMinForm {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        maxMin(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void maxMin(int[] arr) {
        int mid = arr.length / 2;
        int j = arr.length - 1;
        int i = 0;
        int count = 0;
        int[] result = new int[arr.length];
        while (i < mid && j > mid) {
            result[count++] = arr[j];
            result[count++] = arr[i];
            j--;
            i++;
        }
        if (i == j) {
            result[count++] = arr[mid];
        }
        count = 0;
        for (int val : result) {
            arr[count++] = val;
        }
    }

    public static void maxMinM2(int[] arr) {
        //Create a result array to hold re-arranged version of given arr
        int[] result = new int[arr.length];

        int pointerSmall = 0;     //PointerSmall => Start of arr
        int pointerLarge = arr.length - 1;   //PointerLarge => End of arr

        //Flag which will help in switching between two pointers
        boolean switchPointer = true;

        for (int i = 0; i < arr.length; i++) {
            if (switchPointer)
                result[i] = arr[pointerLarge--]; // copy large values
            else
                result[i] = arr[pointerSmall++]; // copy small values

            switchPointer = !switchPointer;   // switching between samll and large
        }

        for (int j = 0; j < arr.length; j++) {
            arr[j] = result[j];    // copying to original array
        }
    }

    public static void maxMinOptimizedSpace(int[] arr) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
        for (int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0) {
                arr[i] += (arr[maxIdx] % maxElem) * maxElem;
                maxIdx -= 1;
            } else { // at odd indices we will store minimum elements
                arr[i] += (arr[minIdx] % maxElem) * maxElem;
                minIdx += 1;
            }
        }
        // dividing with maxElem to get original values.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }
}
