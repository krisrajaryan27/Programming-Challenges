package com.nirvana.learning.interview.array;

/**
 * Given a sequence of integers as an array, determine whether it is possible to obtain a strictly
 * increasing sequence by removing no more than one element from the array.
 * <p>
 * Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an.
 * Sequence containing only one element is also considered to be strictly increasing.
 * Example
 * For sequence = [1, 3, 2, 1], the output should be
 * almostIncreasingSequence(sequence) = false.
 * <p>
 * There is no one element in this array that can be removed in order to get a strictly increasing sequence.
 * For sequence = [1, 3, 2], the output should be
 * almostIncreasingSequence(sequence) = true.
 * <p>
 * You can remove 3 from the array to get the strictly increasing sequence [1, 2].
 * Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].
 */
public class AlmostIncreasingSequence {
    public static void main(String[] args) {
        int[] sequence1 = {1, 3, 2, 1};
        System.out.println(almostIncreasingSequence(sequence1));

        int[] sequence2 = {1, 3, 2};
        System.out.println(almostIncreasingSequence(sequence2));

        int[] sequence3 = {10, 1, 2, 3, 4, 5};
        System.out.println(almostIncreasingSequence(sequence3));
    }

    private static boolean almostIncreasingSequence(int[] sequence) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int count = 0;
        for (int value : sequence) { //10,1,2,3,4,5
            if (value > max) {
                secondMax = max;
                max = value;
            } else if (value > secondMax) {
                max = value;
                count++;
            } else count++;
        }
        return count <= 1;

    }

}
