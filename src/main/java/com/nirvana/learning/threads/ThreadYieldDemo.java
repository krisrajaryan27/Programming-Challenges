package com.nirvana.learning.threads;

class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " in control!");
        }
    }
}

public class ThreadYieldDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 5; i++) {

            Thread.yield();

            System.out.println(Thread.currentThread().getName() + " in control!");
        }
    }
}
