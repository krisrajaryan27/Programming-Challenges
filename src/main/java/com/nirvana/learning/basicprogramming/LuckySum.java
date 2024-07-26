package com.nirvana.learning.basicprogramming;

/***
 * Given 3 int values, a b c, return their sum. However, if one of the values is 13
 * then it does not count towards the sum and values to its right do not count.
 * So for example, if b is 13, then both b and c do not count.
 * luckySum(1, 2, 3) → 6
 * luckySum(1, 2, 13) → 3
 * luckySum(1, 13, 3) → 1
 */
public class LuckySum {

    public static int luckySum(int a, int b, int c) {
        // Check the values and calculate the sum accordingly
        if (a == 13) {
            return 0; // If a is 13, return 0
        } else if (b == 13) {
            return a; // If b is 13, only a counts
        } else if (c == 13) {
            return a + b; // If c is 13, a and b count
        } else {
            return a + b + c; // If none are 13, return the total sum
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(luckySum(1, 2, 3));   // Output: 6
        System.out.println(luckySum(1, 2, 13));  // Output: 3
        System.out.println(luckySum(1, 13, 3));  // Output: 1
        System.out.println(luckySum(13, 2, 3));  // Output: 0
        System.out.println(luckySum(1, 2, 1));   // Output: 4
    }
}

