package com.nirvana.learning.javaeight.lambda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7};
        Set<Integer> set = findDifferences(arr);
        List<Integer> list = new ArrayList<>(set);
        list.sort((a, b) -> (b - a));
        System.out.print(list);
        Integer integer = list.get(5);
        System.out.println(list.get(7));

    }

    public static Set<Integer> findDifferences(int[] arr) {
        Set<Integer> result = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                result.add(Math.abs(arr[j] - arr[i]));
            }
        }
        return result;
    }

}
