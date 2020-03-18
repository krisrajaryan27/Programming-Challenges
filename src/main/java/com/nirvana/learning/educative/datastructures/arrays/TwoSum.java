package com.nirvana.learning.educative.datastructures.arrays;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(findSumBrute(array, 10)));
        System.out.println(Arrays.toString(findSumSort(array, 10)));
        System.out.println(Arrays.toString(findSumUsingHashSet(array, 10)));
        System.out.println(Arrays.toString(twoSum(array, 10)));
    }

    public static int[] findSumBrute(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                    break;
                }
            }
        }
        return result;
    }

    //Helper Function to sort given Array (Quick Sort)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is <= to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    //Return 2 elements of arr that sum to the given value
    public static int[] findSumSort(int[] arr, int n) {
        //Helper sort function that uses the Quicksort Algorithm
        sort(arr, 0, arr.length - 1);   //Sort the array in Ascending Order

        int Pointer1 = 0;    //Pointer 1 -> At Start
        int Pointer2 = arr.length - 1;   //Pointer 2 -> At End

        int[] result = new int[2];
        int sum = 0;

        while (Pointer1 != Pointer2) {

            sum = arr[Pointer1] + arr[Pointer2];  //Calulate Sum of Pointer 1 and 2

            if (sum < n)
                Pointer1++;  //if sum is less than given value => Move Pointer 1 to Right
            else if (sum > n)
                Pointer2--;
            else {
                result[0] = arr[Pointer1];
                result[1] = arr[Pointer2];
                return result; // containing 2 number
            }
        }
        return arr;
    }

    public static int[] findSumUsingHashSet(int[] arr, int n) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(n - i)) {
                result[0] = i;
                result[1] = n - i;
                break;
            }
            set.add(i);
        }
        return result;   // return the elements in the array whose sum is equal to the value passed as parameter
    }

    public static int[] twoSum(int[] arr, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int difference = target - arr[i];
            if (map.containsKey(difference)) {
                result[0] = arr[i];
                result[1] = arr[map.get(difference)];
                return result;
            }
            map.put(arr[i], i);
        }
        return result;
    }
}
