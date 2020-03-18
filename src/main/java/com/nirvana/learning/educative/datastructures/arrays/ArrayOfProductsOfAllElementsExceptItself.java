package com.nirvana.learning.educative.datastructures.arrays;

import org.jetbrains.annotations.NotNull;

public class ArrayOfProductsOfAllElementsExceptItself {
    public static String arrayToString(int[] arr) {
        return getString(arr);
    }

    @NotNull
    static String getString(int[] arr) {
        if (arr.length > 0) {
            StringBuilder result = new StringBuilder();
            for (int value : arr) {
                result.append(value).append(" ");
            }
            return result.toString();
        } else {
            return "Empty Array!";
        }
    }

    public static void main(String[] args) {

        int[] arr = {-1, 2, -3, 4, -5};

        System.out.println("Array before product: " + arrayToString(arr));

        int[] prodArrayM1 = findProductMethod1(arr);
        int[] prodArrayM2 = findProductMethod2(arr);


        System.out.println("Array after product M1: " + arrayToString(prodArrayM1));
        System.out.println("Array after product M2: " + arrayToString(prodArrayM2));
    }

    public static int[] findProductMethod1(int[] arr) {
        int product = 1;
        for (int val : arr) {
            if (val != 0) {
                product *= val;
            }
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                result[i] = product / arr[i];
            } else {
                result[i] = product;
                product = 0;
            }
        }
        return result;
    }

    public static int[] findProductMethod2(int[] arr) {
        int n = arr.length;
        int i;

        // Allocation of result array
        int[] result = new int[n];

        // Initializing the result array by 1
        for (int j = 0; j < n; j++)
            result[j] = 1;

        // Product of elements on left side excluding arr[i]
        int temp = 1;
        for (i = 0; i < n; i++) {
            result[i] = temp;
            temp *= arr[i];
        }

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }
}
