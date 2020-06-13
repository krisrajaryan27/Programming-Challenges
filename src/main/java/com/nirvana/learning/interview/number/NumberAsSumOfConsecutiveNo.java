package com.nirvana.learning.interview.number;

/**
 * @author KrishnaV
 */
public class NumberAsSumOfConsecutiveNo {

    public static void main(String[] args) {
        int N = 100;
        int count = countConsecutive(N);
        System.out.println("Count: " + count);
    }

    static int countConsecutive(int N) {
        // constraint on values of L gives us the
        // time Complexity as O(N^0.5)
        int count = 0;
        for (int n = 1; n * (n + 1) < 2 * N; n++) {
            float a = (float) ((1.0 * N - (n * (n + 1)) / 2) / (n + 1));
            if (a - (int) a == 0.0) {
                System.out.println("First No.: " + a + " No of total numbers to make N: " + (n + 1));
                count++;
            }
        }
        return count;
    }
}
