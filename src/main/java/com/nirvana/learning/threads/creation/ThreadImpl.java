package com.nirvana.learning.threads.creation;

public class ThreadImpl {
    public static void main(String[] args) throws InterruptedException {
        Thread childThread = new Thread(new ChildThread());
        childThread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("From the main thread: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }

}
