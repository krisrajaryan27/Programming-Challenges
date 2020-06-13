package com.nirvana.learning.javaeight.streamapi.parallelstream;

import java.util.stream.Stream;

/**
 * Creating parallel stream using - parallelStream()
 * If stream already present, can be created by parallel()
 */
public class ParallelStreamImpl {
    public static void main(String[] args) {
        //Main thread does all the work in serial stream
        System.out.println("------------------------------- Serial Stream ---------------------------------");
        Stream.of(1, 2, 3, 4, 5, 6, 7)
                .forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));


        //In Parallel stream two threads are spawned simultaneously, and the stream internally uses
        // ForkJoinPool to create and manage threads. Parallel streams create a ForkJoinPool
        // instance via the static ForkJoinPool.commonPool() method.
        System.out.println("-------------------------------- Parallel Stream -----------------------------");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
                .parallel()
                .forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));

        //To use parallel stream, below formula works
        /* NQ Model:

        N x Q > 10000

        where,
                N = number of data items
                Q = amount of work per item*/
    }
}
