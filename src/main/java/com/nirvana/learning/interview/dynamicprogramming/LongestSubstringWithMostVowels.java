package com.nirvana.learning.interview.dynamicprogramming;

public class LongestSubstringWithMostVowels {
    public static void main(String[] args) {
        String s = "qwdftr";
        System.out.println(findSubstring(s, 2));
    }

    public static String findSubstring(String s, int k) {
        // Write your code here
        int count = 0;
        String result = "";
        for (int i = 0; i < s.length() - k + 1; i++) {
            String substr = s.substring(i, i + k);
            if (count < vowelLength(substr)) {
                result = substr;
            }
        }
        if (result.isEmpty()) {
            return "Not found!";
        }
        return result;


    }

    private static int vowelLength(String str) {
        {
            int count = 0;
            char[] s = str.toCharArray();
            for (char c : s) {
                if (isVowel(c))
                    count++;
            }
            return count;
        }
    }

    static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u');
    }
}
