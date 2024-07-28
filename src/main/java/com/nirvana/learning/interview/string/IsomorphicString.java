package com.nirvana.learning.interview.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters. No two characters may map to the same character,
 * but a character may map to itself.
 * <p>
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p>
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * <p>
 * Constraints:
 * 1 <= s.length <= 5 * 104
 * <p>
 * t.length == s.length
 * <p>
 * s and t consist of any valid ascii character.
 **/
public class IsomorphicString {
    public static void main(String[] args) {
        // Example 1
        String s1 = "egg";
        String t1 = "add";
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\", Output: " + isIsomorphic(s1, t1)); // Output: true

        // Example 2
        String s2 = "foo";
        String t2 = "bar";
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\", Output: " + isIsomorphic(s2, t2)); // Output: false

        // Example 3
        String s3 = "paper";
        String t3 = "title";
        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\", Output: " + isIsomorphic(s3, t3)); // Output: true

        // Example 3
        String s4 = "badc";
        String t4 = "baba";
        System.out.println("Input: s = \"" + s4 + "\", t = \"" + t4 + "\", Output: " + isIsomorphic(s4, t4)); // Output: true
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false; // If lengths are different, they can't be isomorphic
        }
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            // Check mapping from s to t
            if (mapS.containsKey(charS)) {
                if (mapS.get(charS) != charT) {
                    return false; // Mismatch in mapping
                }
            } else {
                mapS.put(charS, charT);
            }

            // Check mapping from t to s
            if (mapT.containsKey(charT)) {
                if (mapT.get(charT) != charS) { // Mismatch in mapping
                    return false;
                }
            } else {
                mapT.put(charT, charS);
            }
        }
        return true; // If all mappings are consistent
    } //TC: O(N), SC: O(1)
}
