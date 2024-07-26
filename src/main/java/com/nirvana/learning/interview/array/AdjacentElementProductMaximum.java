package com.nirvana.learning.interview.array;

/**
 * Given an array of integers, find the pair of adjacent elements that has the largest product and return that product.
 * For inputArray = [3, 6, -2, -5, 7, 3], the output should be
 * adjacentElementsProduct(inputArray) = 21.
 * <p>
 * 7 and 3 produce the largest product.
 */
public class AdjacentElementProductMaximum {
    public static void main(String[] args) {
        int[] arr = {3, 6, -2, -5, 7, 3};
        System.out.println("Maximum Product of Adjacent Elements: " + adjacentElementsProduct(arr));
    }

    private static int adjacentElementsProduct(int[] inputArray) {
        int windowStart = 0;
        int windowProduct = inputArray[0];
        int maxProduct = Integer.MIN_VALUE;
        for (int windowEnd = 1; windowEnd < inputArray.length; windowEnd++) {
            windowProduct *= inputArray[windowEnd];
            if (windowProduct > maxProduct) {
                maxProduct = windowProduct;
            }
            if (inputArray[windowStart] != 0) {
                windowProduct /= inputArray[windowStart];
            } else {
                windowProduct = 0;
            }
            windowStart++;
        }
        return maxProduct;
    }

}
