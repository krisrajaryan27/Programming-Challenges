package com.nirvana.learning.basicprogramming;

/***
 Given 3 int values, a b c, return their sum.
 However, if one of the values is the same as another of the values, it does not count towards the sum.


 loneSum(1, 2, 3) → 6
 loneSum(3, 2, 3) → 2
 loneSum(3, 3, 3) → 0
 */
public class LoneSum {
    public static int loneSumM1(int a, int b, int c) {
        int sum = 0;

        // Add a to the sum if it's not equal to b or c
        if (a != b && a != c) {
            sum += a;
        }

        // Add b to the sum if it's not equal to a or c
        if (b != a && b != c) {
            sum += b;
        }

        // Add c to the sum if it's not equal to a or b
        if (c != a && c != b) {
            sum += c;
        }

        return sum;
    }

    public static int loneSumM2(int a, int b, int c) {
        if (a == b && a == c) return 0;
        if (a == b) return c;
        if (a == c) return b;
        if (b == c) return a;
        return a + b + c;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(loneSumM1(1, 2, 3)); // Output: 6
        System.out.println(loneSumM1(3, 2, 3)); // Output: 2
        System.out.println(loneSumM1(3, 3, 3)); // Output: 0

        System.out.println(loneSumM2(1, 2, 3)); // Output: 6
        System.out.println(loneSumM2(3, 2, 3)); // Output: 2
        System.out.println(loneSumM2(3, 3, 3)); // Output: 0


    }
}
