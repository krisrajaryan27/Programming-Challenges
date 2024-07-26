package com.nirvana.learning.basicprogramming;

/***
 Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1),
 while the other is "far", differing from both other values by 2 or more.
 Note: Math.abs(num) computes the absolute value of a number.
 closeFar(1, 2, 10) → true
 closeFar(1, 2, 3) → false
 closeFar(4, 1, 3) → true
 * **/
public class CloseFar {

    public static boolean closeFar(int a, int b, int c) {
        // Check if b is close to a and c is far from both a and b
        boolean bClose = Math.abs(a - b) <= 1;
        boolean cFar = Math.abs(a - c) >= 2 && Math.abs(b - c) >= 2;

        // Check if c is close to a and b is far from both a and c
        boolean cClose = Math.abs(a - c) <= 1;
        boolean bFar = Math.abs(a - b) >= 2 && Math.abs(b - c) >= 2;

        return (bClose && cFar) || (cClose && bFar);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(closeFar(1, 2, 10)); // Output: true
        System.out.println(closeFar(1, 2, 3));  // Output: false
        System.out.println(closeFar(4, 1, 3));  // Output: true
        System.out.println(closeFar(5, 6, 8));  // Output: true
        System.out.println(closeFar(1, 1, 3));  // Output: false

        System.out.println(closeFarM2(1, 2, 10)); // Output: true
        System.out.println(closeFarM2(1, 2, 3));  // Output: false
        System.out.println(closeFarM2(4, 1, 3));  // Output: true
        System.out.println(closeFarM2(5, 6, 8));  // Output: true
        System.out.println(closeFarM2(1, 1, 3));  // Output: false
    }

    public static boolean closeFarM2(int a, int b, int c) {
        int diffAB = Math.abs(a - b);
        int diffAC = Math.abs(a - c);
        int diffBC = Math.abs(b - c);
        if (diffAB <= 1) {
            return diffAC >= 2 && diffBC >= 2;
        }
        if (diffAC <= 1) {
            return diffAB >= 2 && diffBC >= 2;
        }
        return false;
    }

}
