package com.nirvana.learning.threads.interruption;

/**
 * Java provides an interruption mechanism that indicates to a thread that you want to finish it.
 * One peculiarity of this mechanism is that thread objects have to check whether they have been
 * interrupted or not, and they can decide whether they respond to the finalization request or not.
 * A thread object can ignore it and continue with its execution.
 */
public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1L;
        //This loop runs indefinitely.
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }
            //After processing a number, check whether the thread has been interrupted by calling
            // the isInterrupted() method. If this method returns true, the thread has been interrupted.
            // In this case, we write a message in the console and end the execution of the thread:
            if (isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted\n");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
