package com.nirvana.learning.interview.dynamicprogramming.knapsack;

import java.util.Arrays;

public class CountOfSubsetForGivenDifference {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int difference = 1;
        System.out.println(countOfSubsetSumDiffForGivenDiff(arr, difference));
    }

    /*
    sum[subset1] - sum[subset2] = difference -----> eq. 1
    sum[S1]+sum[S2] = sum[arr] ------> eq. 2
    2*sum[S1] = diff + sum[arr]
    sum[S1] = (sum[arr] + diff)/2
    */
    public static int countOfSubsetSumDiffForGivenDiff(int[] arr, int diff) {
        int rangeSum = Arrays.stream(arr).sum();
        int subsetSum1 = (rangeSum + diff) / 2;
        if (diff > rangeSum || diff + rangeSum < 0 || (diff + rangeSum) % 2 == 1) {
            return 0;
        }
        return CountOfSubsetForGivenSum.countOfSubsetSumForGivenSum(arr, subsetSum1);
    }
}
