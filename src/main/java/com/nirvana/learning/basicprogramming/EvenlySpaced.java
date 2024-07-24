package com.nirvana.learning.basicprogramming;

/***
 Given three ints, a b c, one of them is small, one is medium and one is large.
 Return true if the three values are evenly spaced,
 so the difference between small and medium is the same as the difference between medium and large.

 evenlySpaced(2, 4, 6) → true
 evenlySpaced(4, 6, 2) → true
 evenlySpaced(4, 6, 3) → false
 * **/
public class EvenlySpaced {
    public static void main(String[] args) {
        System.out.println(evenlySpaced(2, 4, 6));
        System.out.println(evenlySpaced(4, 6, 2));
        System.out.println(evenlySpaced(4, 6, 3));
    }

    public static boolean evenlySpaced(int a, int b, int c) {
        int maxABC = Math.max(a, Math.max(b, c));
        int minABC = Math.min(a, Math.min(b, c));
        int midABC = a + b + c - maxABC - minABC;
        return (maxABC - midABC) == (midABC - minABC);
    }

}
