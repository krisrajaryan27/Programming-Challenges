package com.nirvana.learning.threads;

import java.util.Random;

public class ThreadUnsafeExample {

    // We'll use this to randomly sleep our threads
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        //Create Object of unsafe counter
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        //setup thread1 to increment the counter 200 times
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.increment();
                    ThreadUnsafeExample.sleepRandomlyForLessThan10Seconds();
                }
            }
        });

        //setup thread2 to decrement the counter 200 times
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.decrement();
                    ThreadUnsafeExample.sleepRandomlyForLessThan10Seconds();
                }
            }
        });

        //run both threads
        thread1.start();
        thread2.start();

        //wait for thread1 and thread2 to complete
        thread1.join();
        thread2.join();

        //print final value of the counter
        badCounter.printFinalValue();

    }

    //It will help in sleeping the threads randomly to give non-deterministic result
    public static void sleepRandomlyForLessThan10Seconds() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ThreadUnsafeCounter {
    int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    void printFinalValue() {
        System.out.println("Counter value is: " + count);
    }
}
