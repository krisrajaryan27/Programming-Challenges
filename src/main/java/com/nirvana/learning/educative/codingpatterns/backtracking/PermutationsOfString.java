package com.nirvana.learning.educative.codingpatterns.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsOfString {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(permutations(str));
    }

    public static List<String> permutations(String str) {
        int length = str.length();
        if (length == 1) {
            return Collections.singletonList(str);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String firstChar = String.valueOf(str.charAt(i));
            String remainingSubstring = str.substring(0, i) + str.substring(i + 1);
            List<String> remainingPermutations = permutations(remainingSubstring);
            for (int j = 0; j < remainingPermutations.size(); j++) {
                result.add(firstChar + remainingPermutations.get(j));
            }
        }
        return result;

    }
}
