package com.nirvana.learning.basicprogramming;

/***
 Given 2 int values greater than 0, return whichever value is nearest to 21 without going over.
 Return 0 if they both go over.
 */
public class BlackJack {
    public static void main(String[] args) {
        System.out.println(blackjack(19, 21));
        System.out.println(blackjack(21, 19));
        System.out.println(blackjack(19, 22));
    }

    public static int blackjack(int a, int b) {
        // Check if both values go over 21
        if (a > 21 && b > 21) {
            return 0;
        }
        // Check if a goes over 21, return b
        if (a > 21) {
            return b;
        }
        // Check if b goes over 21, return a
        if (b > 21) {
            return a;
        }
        // Both values are less than or equal to 21, return the nearest to 21
        return Math.max(a, b);
    }

}
