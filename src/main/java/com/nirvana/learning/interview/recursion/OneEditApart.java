package com.nirvana.learning.interview.recursion;

/**
 * Date 03/26/2019
 *
 * @author Krishna Verma
 * Given two strings S and T, determine if they are both one edit distance apart.
 * <p>
 * Time complexity O(n)
 * Space complexity O(1)
 * <p>
 * Reference
 * https://leetcode.com/problems/one-edit-distance/
 */
public class OneEditApart {

    public static void main(String[] args) {
        OneEditApart oea = new OneEditApart();
        System.out.println(oea.isOneEditDistance("cat", "dog"));
        System.out.println(oea.isOneEditDistance("cat", "cats"));
        System.out.println(oea.isOneEditDistance("cat", "cut"));
        System.out.println(oea.isOneEditDistance("cats", "casts"));
        System.out.println(oea.isOneEditDistance("catsts", "casts"));
    }

    public boolean isOneEditDistance(String s, String t) {
        String larger, smaller;
        if (s.length() < t.length()) {
            larger = t;
            smaller = s;
        } else {
            larger = s;
            smaller = t;
        }

        if (Math.abs(larger.length() - smaller.length()) > 1) {
            return false;
        }

        boolean diffFound = false;
        int j = 0;
        for (int i = 0; i < smaller.length(); ) {
            if (smaller.charAt(i) == larger.charAt(j)) {
                i++;
                j++;
            } else {
                if (diffFound) {
                    return false;
                } else {
                    diffFound = true;
                    if (smaller.length() == larger.length()) {
                        i++;
                        j++;
                    } else {
                        j++;
                    }
                }
            }
        }
        return diffFound || j < larger.length();
    }
}
