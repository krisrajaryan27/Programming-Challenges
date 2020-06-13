package com.nirvana.learning.threads.interruption;

public class PrimeGeneratorMain {
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        //Wait for 5 seconds and interrupt the PrimeGenerator thread:
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //The Thread class has an attribute that stores a boolean value indicating whether the thread has been interrupted or not.
        // When you call the interrupt() method of a thread, you set that attribute to true.
        // The isInterrupted() method only returns the value of that attribute.
        task.interrupt();

        System.out.printf("Main: Status of the Thread: %s\n", task.getState());
        System.out.printf("Main: isInterrupted: %s\n", task.isInterrupted());
        System.out.printf("Main: isAlive: %s\n", task.isAlive());
    }
}
