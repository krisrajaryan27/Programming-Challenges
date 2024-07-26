package com.nirvana.learning.interview.string;

/**
 * Given two strings, find the number of common characters between them.
 * Example
 * For s1 = "aabcc" and s2 = "adcaa", the output should be
 * commonCharacterCount(s1, s2) = 3.
 * Strings have 3 common characters - 2 "a"s and 1 "c".
 */
public class CommonCharacterCount {
    public static void main(String[] args) {
        String str1 = "aabcc";
        String str2 = "adcaa";
        System.out.println(commonCharacterCount(str1, str2));
    }

    private static int commonCharacterCount(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char ch : s1.toCharArray()) {
            freq1[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            freq2[ch - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.min(freq1[i], freq2[i]);
        }
        return count;

    }
}
