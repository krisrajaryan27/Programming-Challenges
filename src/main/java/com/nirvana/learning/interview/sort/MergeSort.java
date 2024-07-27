package com.nirvana.learning.interview.sort;

/**
 * <a href="http://en.wikipedia.org/wiki/Merge_sort">...</a>
 * Test cases
 * 1 element
 * 2 element
 * negative numbers
 * already sorted
 * reverse sorted
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] input1 = {1};
        int[] input2 = {4, 2};
        int[] input3 = {6, 2, 9};
        int[] input4 = {6, -1, 10, 4, 11, 14, 19, 12, 18};
        mergeSort(input1);
        mergeSort(input2);
        mergeSort(input3);
        mergeSort(input4);

        printArray(input1);
        printArray(input2);
        printArray(input3);
        printArray(input4);
    }

    public static void mergeSort(int[] input) {
        if (input.length < 2) return;
        mergeSort(input, 0, input.length - 1);
    }

    private static void mergeSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(input, left, mid);
        mergeSort(input, mid + 1, right);
        merge(input, left, mid, right);
    }

    // Function to merge two halves
    private static void merge(int[] input, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int leftArraySize = mid - left + 1;
        int rightArraySize = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        // Copy data to temporary arrays
        System.arraycopy(input, left, leftArray, 0, leftArraySize);
        for (int j = 0; j < rightArraySize; j++) {
            rightArray[j] = input[mid + 1 + j];
        }

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int index = left;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                input[index] = leftArray[i];
                i++;
            } else {
                input[index] = rightArray[j];
                j++;
            }
            index++;
        }

        // Copy remaining elements of leftArray if any
        while (i < leftArraySize) {
            input[index] = leftArray[i];
            i++;
            index++;
        }

        // Copy remaining elements of rightArray if any
        while (j < rightArraySize) {
            input[index] = rightArray[j];
            j++;
            index++;
        }
    }

    public static void printArray(int[] input) {
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
