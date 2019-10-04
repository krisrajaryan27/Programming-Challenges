package com.nirvana.learning.threadpool.utils;

/**
 * @author KrishnaV
 */
public class CounterClient {
    public static void main(String... args) {
        Counter counter = new Counter(Integer.MAX_VALUE - 1);

        synchronized (counter) {
            if (counter.get() < Integer.MAX_VALUE) {
                System.out.println(counter.getAndIncrement());
            } else {
                System.err.println("That would overflow");
            }
        }
    }
}
