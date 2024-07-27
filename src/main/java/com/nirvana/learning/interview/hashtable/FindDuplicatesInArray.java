package com.nirvana.learning.interview.hashtable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * Given an array of integers, find if the array contains any duplicates.
 * **/
public class FindDuplicatesInArray {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 2, 3);
        System.out.println(findDuplicates(list));
    }

    public static boolean findDuplicates(List<Integer> keys) {
        Set<Integer> hashSet = new HashSet<>();
        for (int key : keys) {
            if (hashSet.contains(key)) {
                return true;
            }
            hashSet.add(key);
        }
        return false;

    }
}
