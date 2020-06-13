package com.nirvana.learning.basicprogramming;

import java.util.*;

public class Test2 {
    public static int chooseFlask(List<Integer> requirements, int flaskTypes, List<List<Integer>> markings) {
        // Write your code here
        List<Integer> resultIntegers = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < markings.size(); i++) {
            int value = markings.get(i).get(1);
            if (value != i) {
                int sum = getSumOfDifference(requirements, value);
                resultIntegers.add(sum);
                if (markings.get(i).get(0) != count) {
                    count++;
                } else {
                    map.put(sum, count);
                }

            }
        }
        Collections.sort(resultIntegers);
        if (map.containsKey(resultIntegers.get(0))) {
            return map.get(resultIntegers.get(0));
        }
        return 0;
    }

    public static int getSumOfDifference(List<Integer> requirements, int value) {
        int count = 0;
        int sum = 0;
        while (count < requirements.size()) {
            int difference = value - requirements.get(count);
            if (difference >= 0) {
                sum += difference;
            }
            count++;
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
