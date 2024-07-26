package com.nirvana.learning.javaeight;

import java.util.Arrays;
import java.util.List;

public class SecondHighestNumber {
    public static void main(String[] args) throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 6, 7, 10, 9);
        System.out.println(getSecondHighestNumber(list));
    }

    private static int getSecondHighestNumber(List<Integer> list) throws Exception {
        if (list.isEmpty() || list.size() < 2) throw new Exception("Second highest no is not found");
        int firstHighest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int num : list) {
            if (num > firstHighest) {
                secondHighest = firstHighest;
                firstHighest = num;
            } else if (num > secondHighest && num != firstHighest) {
                secondHighest = num;
            }
        }
        if (secondHighest == Integer.MIN_VALUE) {
            throw new Exception("Second Highest Number is not found");
        }
        return secondHighest;
    }
}
