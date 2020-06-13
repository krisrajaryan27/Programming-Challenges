package com.nirvana.learning.interview.number;

/**
 * http://www.geeksforgeeks.org/lucky-numbers/
 */
public class LuckyNumbers {

    public static void main(String[] args) {
        LuckyNumbers ln = new LuckyNumbers();
        System.out.println(ln.isLuck(19, 2));
    }

    public boolean isLuck(int n, int counter) {
        if (n < counter) {
            return true;
        }
        if (n % counter == 0) {
            return false;
        }

        return isLuck(n - n / counter, counter + 1);
    }

}
