package com.nirvana.learning.interview.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * <p>
 * References
 * <p>
 * <a href="http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/">GeeksForGeeks</a>
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Leetcode</a>
 */
public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ABCDECAMNCZB"));
        String s1 = "abcabcbb";
        System.out.println("Example 1 Output: " + lengthOfLongestSubstring(s1)); // Output: 3

        // Example 2
        String s2 = "bbbbb";
        System.out.println("Example 2 Output: " + lengthOfLongestSubstring(s2)); // Output: 1

        // Example 3
        String s3 = "pwwkew";
        System.out.println("Example 3 Output: " + lengthOfLongestSubstring(s3)); // Output: 3
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0; // Left pointer for the sliding window
        int maxLength = 0; // To store the maximum length found

        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, we need to shrink the window
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the set
            charSet.add(s.charAt(right));
            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
