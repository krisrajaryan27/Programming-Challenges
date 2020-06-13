package com.nirvana.learning.interview.number;

/**
 * http://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/
 * Test cases
 * k is 0
 * k or n are negative
 * k greater than n
 */
public class BinomialCoefficient {

    public static void main(String[] args) {
        BinomialCoefficient bc = new BinomialCoefficient();
        System.out.print(bc.calculate(8, 3));
    }

    public int calculate(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }
        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}
