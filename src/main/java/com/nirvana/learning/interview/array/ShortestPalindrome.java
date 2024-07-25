package com.nirvana.learning.interview.array;

/**
 * Date 03/04/2019
 *
 * @author Krishna Verma
 * <p>
 * How to append minimum numbers of characters in front of string to make it a palindrome.
 * <p>
 * Idea is to create a new string which is original ttring + $ + reverse of original string
 * Get value of suffix which is also prefix using KMP.
 * This part of string is good. Rest needs to be copied in the front.
 * <p>
 * Time complexity is O(n)
 * Space complexity is O(n)
 * <p>
 * <a href="https://leetcode.com/problems/shortest-palindrome/">...</a>
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();
        System.out.print(sp.shortestPalindrome("aacecaaa"));
    }

    public String shortestPalindrome(String s) {
        char[] input = createInput(s);
        int val = kmp(input);

        StringBuilder sb = new StringBuilder();
        int remaining = s.length() - val;
        int i = s.length() - 1;
        while (remaining > 0) {
            sb.append(s.charAt(i));
            i--;
            remaining--;
        }
        sb.append(s);
        return sb.toString();

    }

    private int kmp(char[] input) {
        int[] T = new int[input.length];

        int j = 1;
        int i = 0;

        T[0] = 0;

        while (j < input.length) {
            if (input[i] == input[j]) {
                T[j] = i + 1;
                i++;
            } else {
                while (i != 0) {
                    i = T[i - 1];
                    if (input[j] == input[i]) {
                        T[j] = i + 1;
                        i++;
                        break;
                    }
                }
            }
            j++;
        }
        return T[input.length - 1];
    }

    private char[] createInput(String s) {
        char[] input = new char[2 * s.length() + 1];
        int index = 0;
        for (char ch : s.toCharArray()) {
            input[index++] = ch;
        }
        input[index++] = '$';

        for (int i = s.length() - 1; i >= 0; i--) {
            input[index++] = s.charAt(i);
        }
        return input;
    }
}
