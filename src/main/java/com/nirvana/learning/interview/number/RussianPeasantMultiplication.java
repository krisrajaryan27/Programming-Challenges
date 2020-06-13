package com.nirvana.learning.interview.number;

/**
 * http://www.geeksforgeeks.org/fast-multiplication-method-without-using-multiplication-operator-russian-peasants-algorithm/
 * Test cases
 * Division by 0
 * Negative numbers
 */
public class RussianPeasantMultiplication {

    public static void main(String[] args) {
        RussianPeasantMultiplication rpm = new RussianPeasantMultiplication();
        System.out.println(rpm.multiply(7, 13));
    }

    public int multiply(int a, int b) {
        int res = 0;
        while (b > 0) {
            if (b % 2 != 0) {
                res += a;
            }
            a = a << 1;
            b = b >> 1;
        }
        return res;
    }
}
