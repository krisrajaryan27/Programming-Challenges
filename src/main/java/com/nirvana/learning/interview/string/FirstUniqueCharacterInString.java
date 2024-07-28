package com.nirvana.learning.interview.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the first non-repeating character in it
 * and return its index. If it does not exist, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 0
 * <p>
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * <p>
 * s consists of only lowercase English letters.
 */
public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        // Example 1
        String s1 = "leetcode";
        System.out.println("Input: \"" + s1 + "\", Output: " + firstUniqueCharacter(s1)); // Output: 0

        // Example 2
        String s2 = "loveleetcode";
        System.out.println("Input: \"" + s2 + "\", Output: " + firstUniqueCharacter(s2)); // Output: 2

        // Example 3
        String s3 = "aabb";
        System.out.println("Input: \"" + s3 + "\", Output: " + firstUniqueCharacter(s3)); // Output: -1
    }

    public static int firstUniqueCharacter(String s) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        // Count occurrences of each character
        for (char ch : s.toCharArray()) {
            characterCountMap.put(ch, characterCountMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (characterCountMap.get(s.charAt(i)) == 1)
                return i; // Return the index of the first non-repeating character
        }
        // If there is no non-repeating character
        return -1;
    }
}
