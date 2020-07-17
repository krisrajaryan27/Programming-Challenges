package com.nirvana.learning.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=virtusa
 *
 * @author Krishna Verma
 */
public class TwoStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        while (n > 0) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(twoStrings(s1, s2));
            n--;
        }
    }

    private static boolean twoStrings(String str1, String str2) {
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        for (char ch : str1.toCharArray()) {
            s1.add(ch);
        }
        for (char ch : str2.toCharArray()) {
            s2.add(ch);
        }
        s1.retainAll(s2);
        return !s1.isEmpty();
    }
}
