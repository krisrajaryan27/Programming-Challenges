package com.nirvana.learning.educative.datastructures.arrays;

import org.jetbrains.annotations.NotNull;

public class FirstNonRepeatingIntegerInArray {
    public static void main(String[] args) {
        int[] arr = {2, 54, 7, 2, 6, 54};

        System.out.println("Array: " + arrayToString(arr));

        int unique = findFirstUnique(arr);
        System.out.print("First Unique in an Array: " + unique);
    }

    public static int findFirstUnique(int[] arr) {
        //Inside Inner Loop Check Each index of outerLoop If it's repeated in array
        //If it's not repeated then return this as first unique Integer
        boolean isRepeated = false;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (arr[i] == arr[j] && i != j) {
                    isRepeated = true;
                    break;
                }
            } //end of InnerLoop

            if (!isRepeated) {
                return arr[i];
            } else {
                isRepeated = false;
            }

        } //end of OuterLoop
        return -1;
    }

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

    public static int findFirstUniqueBrute(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int j;
            for (j = 0; j < len; j++)
                if (i != j && arr[i] == arr[j])
                    break;
            if (j == len)
                return arr[i];
        }

        return -1;
    }
}
