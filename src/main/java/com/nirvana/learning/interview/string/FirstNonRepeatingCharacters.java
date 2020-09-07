package com.nirvana.learning.interview.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s consisting of small English letters,
 * find and return the first instance of a non-repeating character in it.
 * If there is no such character, return '_'.
 * <p>
 * Example
 * For s = "abacabad", the output should be
 * firstNotRepeatingCharacter(s) = 'c'.
 * There are 2 non-repeating characters in the string: 'c' and 'd'.
 * Return c since it appears in the string first.
 * For s = "abacabaabacaba", the output should be
 * firstNotRepeatingCharacter(s) = '_'.
 * <p>
 * There are no characters in this string that do not repeat.
 */
public class FirstNonRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abacabad";
        System.out.println(firstNotRepeatingCharacterBrute(str));
        System.out.println(firstNotRepeatingCharacterDS(str));
        System.out.println(firstNotRepeatingCharacterAlphabet(str));
        System.out.println(firstNotRepeatingCharacterOptimised(str));

    }

    private static char firstNotRepeatingCharacterBrute(String s) {
        boolean isVisited = false;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && i != j) {
                    isVisited = true;
                    break;
                }
            }
            if (!isVisited) {
                return s.charAt(i);
            } else {
                isVisited = false;
            }
        }
        return '_';
    }

    private static char firstNotRepeatingCharacterDS(String s) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterIntegerMap.containsKey(c)) {
                characterIntegerMap.put(c, characterIntegerMap.get(c) + 1);
            } else {
                characterIntegerMap.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (characterIntegerMap.get(ch) == 1) return ch;
        }
        return '_';
    }

    private static char firstNotRepeatingCharacterAlphabet(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (charCounts[c - 'a'] == 1) return c;
        }
        return '_';
    }

    private static char firstNotRepeatingCharacterOptimised(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return c;
            }
        }
        return '_';
    }

}
