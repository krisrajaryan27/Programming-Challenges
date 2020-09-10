package com.nirvana.learning.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Some people are standing in a row in a park. There are trees between them which cannot be moved.
 * Your task is to rearrange the people by their heights in a non-descending order without
 * moving the trees. People can be very tall!
 * Example
 * For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
 * sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
 * If a[i] = -1, then the ith position is occupied by a tree.
 * Otherwise a[i] is the height of a person standing in the ith position.
 */
public class SortByHeight {
    public static void main(String[] args) {
        int[] a = {-1, 150, 190, 170, -1, -1, 160, 180};
        int[] sortByHeight = sortByHeight(a);
        Arrays.stream(sortByHeight).forEach(System.out::println);
    }

    private static int[] sortByHeight(int[] a) {
        int[] temp = a.clone();
        Arrays.sort(a);
        List<Integer> list = new ArrayList<>();
        for (int n : a) {
            if (n != -1)
                list.add(n);
        }
        for (int i = 0, j = 0; i < temp.length; i++) {
            if (temp[i] != -1) {
                temp[i] = list.get(j);
                j++;
            }
        }
        return temp;
    }
}
