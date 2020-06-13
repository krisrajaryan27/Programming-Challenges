package com.nirvana.learning.hackerrank;

public class MultiRun extends Thread {

    String str;

    public MultiRun(String s) {
        this.str = s;
    }

    public void run(String[] args) {
        System.out.println("Start");
    }

/*implements Runnable {
    @Override
    public void run() {
        System.out.println("run-a");
    }*/
}


