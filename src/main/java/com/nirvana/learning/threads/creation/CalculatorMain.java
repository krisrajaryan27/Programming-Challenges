package com.nirvana.learning.threads.creation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
 * <p>
 * A Java program with more than one execution thread only finishes when the execution of all of its threads end
 * (more specifically, when all its non-daemon threads end their execution or when one of the threads uses
 * the System.exit() method)
 */
public class CalculatorMain {
    public static void main(String[] args) throws IOException {

        //Information regarding max min and default priority of threads
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);

        //10 threads to execute 10 Calculator tasks and store those threads and its statuses.
        //Execute 5 threads(even ones) as max priority and other 5 as min priority
        Thread[] threads = new Thread[10];
        Thread.State[] status = new Thread.State[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator());
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread " + i);
        }

        //Write info and status of threads in a text file before launching them
        try (FileWriter file = new FileWriter("log.txt"); PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + " : " +
                        threads[i].getState());
                status[i] = threads[i].getState();
            }
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            //Wait for finalization of threads
            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Write info about the status of a thread in a file.
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : ************************************\n");
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }


}
