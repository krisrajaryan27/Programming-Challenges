package com.nirvana.learning.interview.string;


/**
 * There is a string str of lowercase English letters that is repeated infinitely many times.
 * Given an integer n, find and print the number of letter a's in the first n letters of the infinite string.
 * Example str = "abcac" n = 10
 * The substring we consider is "abcacabcac", the first 10 characters of the infinite string.
 * There are 4 occurrences of a in the substring.
 * <a href="https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup">...</a>
 **/
public class RepeatedString {
    public static long repeatedString(String s, long n) {
        int length = s.length();
        // Count the number of 'a's in the original string
        long countAInS = s.chars().filter(ch -> ch == 'a').count();

        // Calculate how many complete repetitions of the string fit into n
        long completeRepetitions = n / length;

        // Count 'a's from complete repetitions
        long totalCountA = completeRepetitions * countAInS;

        // Count 'a's in the remaining substring
        long remainder = n % length;
        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                totalCountA++;
            }
        }

        return totalCountA;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(repeatedString("aba", 10)); // Output: 7
        System.out.println(repeatedString("a", 1000000000)); // Output: 1000000000
        System.out.println(repeatedString("abc", 7)); // Output: 2
        System.out.println(repeatedString("abcac", 10)); // Output: 4
    }
}
