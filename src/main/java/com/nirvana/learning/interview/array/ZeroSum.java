package com.nirvana.learning.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ZeroSum {

    public static List<Integer> zeroSum(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        if (arr.length < 2) {
            return null;
        }
        int currentSum = 0;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        while (i < j) {
            currentSum = arr[i] + arr[j];
            if (currentSum == 0) {
                list.add(arr[i]);
                list.add(arr[j]);
                i++;
            } else if (currentSum < 0) {
                i++;
            } else j--;
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(zeroSum(arr));
    }
}
