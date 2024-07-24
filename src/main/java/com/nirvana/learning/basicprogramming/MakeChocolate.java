package com.nirvana.learning.basicprogramming;

/***
 We want make a package of goal kilos of chocolate.
 We have small bars (1 kilo each) and big bars (5 kilos each).
 Return the number of small bars to use, assuming we always use big bars before small bars.
 Return -1 if it can't be done.


 makeChocolate(4, 1, 9) → 4
 makeChocolate(4, 1, 10) → -1
 makeChocolate(4, 1, 7) → 2
 */
public class MakeChocolate {
    public static void main(String[] args) {
        System.out.println(makeChocolate(4, 1, 9));
        System.out.println(makeChocolate(4, 1, 10));
        System.out.println(makeChocolate(4, 1, 7));
    }

    public static int makeChocolate(int small, int big, int goal) {
        // Calculate the maximum number of big bars we can use without exceeding the goal
        int maxBigBars = Math.min(big, goal / 5);

        // Calculate the remaining weight that needs to be filled with small bars
        int remainingWeight = goal - (maxBigBars * 5);

        // Check if we have enough small bars to meet the remaining weight
        if (remainingWeight <= small) {
            return remainingWeight; // Return the number of small bars needed
        } else {
            return -1; // Not enough small bars to meet the goal
        }

    }

}
