package com.nirvana.learning.interview.number;

/**
 * Ticket numbers usually consist of an even number of digits.
 * A ticket number is considered lucky if the sum of the first half
 * of the digits is equal to the sum of the second half.
 * <p>
 * Given a ticket number n, determine if it's lucky or not.
 * Example
 * For n = 1230, the output should be
 * isLucky(n) = true;
 * For n = 239017, the output should be
 * isLucky(n) = false.
 */
public class IsLuckyNumber {
    public static void main(String[] args) {
        System.out.println(isLucky(1230));
        System.out.println(isLucky(239017));
        System.out.println(isLuckyOptimised(239017));
    }

    private static boolean isLucky(int n) {
        String num = String.valueOf(n);
        int length = num.length();
        int firstHalfSum = 0;
        int secondHalfSum = 0;
        for (int i = 0; i < length / 2; i++) {
            firstHalfSum += Integer.parseInt(String.valueOf(num.charAt(i)));
            secondHalfSum += Integer.parseInt(String.valueOf(num.charAt(length - i - 1)));
        }
        return firstHalfSum == secondHalfSum;
    }

    private static boolean isLuckyOptimised(int n) {
        String s = n + "";
        int sum = 0;
        for (int i = 0; i < s.length() / 2; i++)
            sum += (s.charAt(i) - s.charAt(s.length() - 1 - i));
        return sum == 0;
    }

}
