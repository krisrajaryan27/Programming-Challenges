package com.nirvana.learning.threadpool.utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

/**
 * @author KrishnaV
 */
public class ParallelSorting {
    public static void main(String[] args) {
        /* Number is random and not sorted. Hence parallel sorting is better.
           However if numbers are sorted in that case, sequential sorting is way faster.
         */
        int[] numbers = ThreadLocalRandom.current()
                .ints(100_000_000)
                .toArray();
        for (int i = 0; i < 1000;i++){
            testSorting(numbers);
        }
    }

    private static void testSorting(int[] numbers) {
        int[] numbersSeq = numbers.clone();
        int[] numbersPar = numbers.clone();
        sort("Sequential",numbersSeq,Arrays::sort);
        sort("Parallel",numbersPar,Arrays::parallelSort);
    }

    private static void sort(String sortDesc, int[] numbers, Consumer<int[]> sortAlgo) {
        long time = System.currentTimeMillis();
        try {
            sortAlgo.accept(numbers);
        } finally {
            time = System.currentTimeMillis() - time;
            System.out.println(sortDesc+" Sort time = "+time+ " ms");
        }
    }
    }

