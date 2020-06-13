package com.nirvana.learning.threads.creation;

/**
 * Info stored in Thread Class.
 * 1. ID - unique identifier for each thread.
 * 2. Name - name of the thread.
 * 3. Priority - Threads can have priority between 1 and 10, where 1 is the lowest priority and 10 is the highest.
 * It's not recommended that you change the priority of the threads. It's only a hint to the underlying operating
 * system and it doesn't guarantee anything, but it's a possibility that you can use if you want.
 * 4. Status - status of a thread. In Java, a thread can be present in one of the six states defined in the Thread.
 * State enumeration: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, or TERMINATED.
 * NEW: The thread has been created and it has not yet started.
 * RUNNABLE: The thread is being executed in the JVM.
 * BLOCKED: The thread is blocked and it is waiting for a monitor.
 * WAITING: The thread is waiting for another thread.
 * TIMED_WAITING: The thread is waiting for another thread with a specified waiting time.
 * TERMINATED: The thread has finished its execution.
 */
public class ChildThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("From the Child thread: "
                    + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
