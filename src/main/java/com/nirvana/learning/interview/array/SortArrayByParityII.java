package com.nirvana.learning.interview.array;

import java.util.Arrays;

/**
 * @author KrishnaV
 */
public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        System.out.println(sortArrayByParityII(A));
    }

    public static int[] sortArrayByParityII(int[] A) {
        int[] odd = Arrays.stream(A).filter(value -> (value % 2 != 0)).toArray();
        int[] even = Arrays.stream(A).filter(value -> (value % 2 == 0)).toArray();
        int[] result = new int[A.length];
        int counter = 0;
        for (int i = 0; i < A.length / 2; i++) {
            result[counter++] = even[i];
            result[counter++] = odd[i];

        }
        return result;
    }
}
