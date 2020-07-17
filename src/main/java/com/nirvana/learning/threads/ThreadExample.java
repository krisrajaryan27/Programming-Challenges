package com.nirvana.learning.threads;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        SumExample.runTests();
    }
}

class SumExample {
    long startRange;
    long endRange;
    long counter;
    static long MAX_VALUE = Integer.MAX_VALUE;

    public SumExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add() {
        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }

    public static void twoThreads() throws InterruptedException {
        long start = System.currentTimeMillis();
        SumExample s1 = new SumExample(1, MAX_VALUE / 2);
        SumExample s2 = new SumExample(1 + (MAX_VALUE / 2), MAX_VALUE);

        Thread t1 = new Thread(s1::add);
        Thread t2 = new Thread(s2::add);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took " + (end - start));

    }

    public static void oneThread() {

        long start = System.currentTimeMillis();
        SumExample s = new SumExample(1, MAX_VALUE);
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
    }

    public static void runTests() throws InterruptedException {
        oneThread();
        twoThreads();
    }
}