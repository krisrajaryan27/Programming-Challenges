package com.nirvana.learning.interview.hashtable;

import java.util.HashSet;
import java.util.Set;

/***
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 231 - 1
 * <p>
 * **/
public class HappyNumber {
    public static void main(String[] args) {
        // Example 1
        int n1 = 19;
        System.out.println("Input: " + n1 + ", Output: " + isHappy(n1)); // Output: true
        System.out.println("Input: " + n1 + ", Output: " + isHappyM2(n1)); // Output: true

        // Example 2
        int n2 = 2;
        System.out.println("Input: " + n2 + ", Output: " + isHappy(n2)); // Output: false
        System.out.println("Input: " + n2 + ", Output: " + isHappyM2(n2)); // Output: false
    }

    public static boolean isHappy(int num) {
        Set<Integer> seen = new HashSet<>();

        while (num != 1) {
            if (seen.contains(num)) {
                return false; // Cycle detected
            }
            seen.add(num);
            num = sumOfSquares(num);
        }
        return true; // Reached 1
    } //TC: O(logN), SC:O(k)

    public static boolean isHappyM2(int num) {
        int slow = num;
        int fast = num;
        //while loop is not used here because initially slow and
        //fast pointer will be equal only, so the loop won't run.
        do {
            //slow moving one step ahead and fast moving two steps ahead
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);

        //if a cycle exists, then the number is not a happy number
        //and slow will have a value other than 1
        return slow == 1;
    } //TC: O(N), SC:O(1)


    private static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

}
