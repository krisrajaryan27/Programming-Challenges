package com.nirvana.learning.basicprogramming;

/***
 We want to make a row of bricks that is goal inches long.
 We have a number of small bricks (1 inch each) and big bricks (5 inches each).
 Return True if it is possible to make the goal by choosing from the given bricks.
 This is a little harder than it looks and can be done without any loops.

 make_bricks(3, 1, 8) → True
 make_bricks(3, 1, 9) → False
 make_bricks(3, 2, 10) → True
 ***/
public class MakeBricks {
    public static void main(String[] args) {
        System.out.println(makeBricks(3, 1, 8));
        System.out.println(makeBricks(3, 1, 9));
        System.out.println(makeBricks(3, 2, 10));
    }

    public static boolean makeBricks(int small, int big, int goal) {
//        //Fail Case #1: not enough bricks
//        if (goal > big * 5 + small) return false;
//
//        //Fail Case #2: not enough small bricks
//        if (goal % 5 > small) return false;
//
//        return true;

        int maxBigBricks = Math.min(big, goal / 5);

        // Calculate the remaining length that needs to be filled with small bricks
        int remainingLength = goal - (maxBigBricks * 5);

        // Check if we have enough small bricks to meet the remaining length
        return remainingLength <= small;
    }

}
