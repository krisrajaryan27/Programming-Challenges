package com.nirvana.learning.basicprogramming;

/***
 * Given 3 int values, a b c, return their sum.
 * However, if any of the values is a teen -- in the range 13..19 inclusive --
 * then that value counts as 0, except 15 and 16 do not count as a teens.
 * Write a separate helper "public int fixTeen(int n) {"
 * that takes in an int value and returns that value fixed for the teen rule.
 * In this way, you avoid repeating the teen code 3 times (i.e. "decomposition").
 * Define the helper below and at the same indent level as the main noTeenSum().
 * noTeenSum(1, 2, 3) → 6
 * noTeenSum(2, 13, 1) → 3
 * noTeenSum(2, 1, 14) → 3
 * */
public class TeenSum {

    public static int noTeenSum(int a, int b, int c) {
        return fixTeen(a) + fixTeen(b) + fixTeen(c); // Sum the fixed values
    }

    public static int fixTeen(int num) {
        // Check if the number is a teen, excluding 15 and 16
        if (num >= 13 && num <= 19 && num != 15 && num != 16) {
            return 0; // Return 0 for teens except 15 and 16
        }
        return num; // Return the original number if not a teen
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(noTeenSum(1, 2, 3));   // Output: 6
        System.out.println(noTeenSum(2, 13, 1));  // Output: 3
        System.out.println(noTeenSum(2, 1, 14));  // Output: 3
        System.out.println(noTeenSum(15, 16, 17)); // Output: 31
        System.out.println(noTeenSum(13, 14, 15)); // Output: 15
    }
}
