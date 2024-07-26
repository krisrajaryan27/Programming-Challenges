package com.nirvana.learning.interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of strings, return another array containing all of its longest strings.
 * Example
 * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
 * allLongestStringsBrute(inputArray) = ["aba", "vcd", "aba"].
 */
public class AllLongestStrings {
    public static void main(String[] args) {
        String[] inputArray = {"aba", "aa", "ad", "vcd", "abd"};
        Arrays.stream(allLongestStringsBrute(inputArray)).forEach(System.out::println);
        Arrays.stream(allLongestStrings(inputArray)).forEach(System.out::println);
    }

    private static String[] allLongestStringsBrute(String[] inputArray) {
        int maxLen = inputArray[0].length();
        for (String str : inputArray) {
            int len = str.length();
            if (len > maxLen) {
                maxLen = len;
            }
        }

        List<String> list = new ArrayList<>();
        for (String str : inputArray) {
            int len = str.length();
            if (len == maxLen) {
                list.add(str);
            }
        }
        String[] itemsArray = new String[list.size()];
        itemsArray = list.toArray(itemsArray);
        return itemsArray;
    }

    private static String[] allLongestStrings(String[] inputArray) {
        StringBuilder stringBuilder = new StringBuilder(); //full string with "-" separator

        for (String s : inputArray) {
            //length is first index of substring
            //if list has same size strings, add this one
            if (stringBuilder.indexOf("-") == s.length()) stringBuilder.append(s).append("-");
                //reset if list has smaller strings
            else if (stringBuilder.indexOf("-") < s.length()) stringBuilder = new StringBuilder(s + "-");
        }

        return stringBuilder.toString().split("-");
    }

}
