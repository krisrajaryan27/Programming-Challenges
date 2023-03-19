package com.nirvana.learning.interview.array;

/***
 * Given an array of size N. Find the max and min element in the array using minimum no of comparisons
 *
 * */
public class MaxMinPair {
    static class Pair {
        int max;
        int min;
    }

    static Pair getMinMaxPair(int[] arr, int n) {
        Pair minMax = new Pair();
        int i;
        if (n == 1) {
            minMax.min = arr[0];
            minMax.max = arr[0];
            return minMax;
        }
        if (arr[0] > arr[1]) {
            minMax.min = arr[1];
            minMax.max = arr[0];
        } else {
            minMax.min = arr[0];
            minMax.max = arr[1];
        }
        for (i = 2; i < n; i++) {
            if (arr[i] > minMax.max) minMax.max = arr[i];
            else if (arr[i] < minMax.min) minMax.min = arr[i];
        }
        return minMax;
    }

    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 230, 3001};
        Pair minMax = getMinMaxPair(arr, arr.length);
        System.out.println("Minimum value: " + minMax.min + " Maximum value: " + minMax.max);
    }
}
