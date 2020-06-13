package com.nirvana.learning.educative.codingpatterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring which has no repeating characters.
 */
public class LengthOfLongestSubstringWithNoRepeatingChars {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LengthOfLongestSubstringWithNoRepeatingChars.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + LengthOfLongestSubstringWithNoRepeatingChars.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + LengthOfLongestSubstringWithNoRepeatingChars.findLength("abccde"));
    }

    //O(N)
    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }
}
