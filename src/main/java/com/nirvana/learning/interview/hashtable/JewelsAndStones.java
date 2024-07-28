package com.nirvana.learning.interview.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings jewels representing the types of stones that are jewels,
 * and stones representing the stones you have.
 * Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 * <p>
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * 1 <= jewels.length, stones.length <= 50
 * <p>
 * jewels and stones consist of only English letters.
 * All the characters of jewels are unique.
 * <a href="https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1136/">Link</a>
 */
public class JewelsAndStones {

    public static int numJewelsInStones(String jewels, String stones) {
        // Create a HashSet to store the jewels for quick lookup
        Set<Character> jewelSet = new HashSet<>();

        // Add each jewel to the set
        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }

        // Count the number of stones that are jewels
        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example 1
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        System.out.println("Example 1 Output: " + numJewelsInStones(jewels1, stones1)); // Output: 3

        // Example 2
        String jewels2 = "z";
        String stones2 = "ZZ";
        System.out.println("Example 2 Output: " + numJewelsInStones(jewels2, stones2)); // Output: 0
    }
}
