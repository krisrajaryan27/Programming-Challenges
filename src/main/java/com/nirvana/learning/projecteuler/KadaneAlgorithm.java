package com.nirvana.learning.projecteuler;

/**
 * @author KrishnaV
 */
public class KadaneAlgorithm {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(arr));
    }

    private static int maxSubArraySum(int[] arr) {
        int size = arr.length;
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for (int i = 0; i < size; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            } else if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }
}
