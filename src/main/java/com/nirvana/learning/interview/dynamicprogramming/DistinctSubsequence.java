package com.nirvana.learning.interview.dynamicprogramming;

/**
 * Date 03/20/2019
 *
 * @author Krishna Verma
 * <p>
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * <p>
 * Time complexity O(n^2)
 * Space complexity O(n^2)
 * <p>
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequence {
    public static void main(String[] args) {
        DistinctSubsequence ds = new DistinctSubsequence();
        System.out.println(ds.numDistinct("abdacgblc", "abc"));
    }

    public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int[][] T = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < T[0].length; i++) {
            T[0][i] = 1;
        }
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    T[i][j] = T[i - 1][j - 1] + T[i][j - 1];
                } else {
                    T[i][j] = T[i][j - 1];
                }
            }
        }
        return T[t.length()][s.length()];
    }
}
