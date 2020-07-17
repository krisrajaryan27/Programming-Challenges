package com.nirvana.learning.threads.creation;

import java.util.concurrent.*;

/**
 * Four ways to create a thread by:
 * 1. Extending Thread Class
 * 2. Implementing Runnable Interface
 * 3. Implementing Callable Interface
 * 4. Using the Executor Framework along with Runnable and Callable Tasks
 */
public class ThreadCreationDemo {

    public static void main(String[] args) {
        //1. Extending Thread class
        Thread workerThread1 = new Worker();
        Thread workerThread2 = new Worker();
        Thread workerThread3 = new Worker();
        workerThread1.start();
        workerThread2.start();
        workerThread3.start();

        //2. Implementing Runnable Interface
        Runnable runnable = new RunnableWorker();
        Thread runnableThread1 = new Thread(runnable);
        Thread runnableThread2 = new Thread(runnable);
        Thread runnableThread3 = new Thread(runnable);
        runnableThread1.start();
        runnableThread2.start();
        runnableThread3.start();

        //3. Implementing Callable Interface
        FutureTask<Integer>[] futureTaskList = new FutureTask[5];
        for (int i = 0; i < 5; i++) {
            Callable<Integer> callable = new CallableTask();
            futureTaskList[i] = new FutureTask<>(callable);
            Thread thread = new Thread(futureTaskList[i]);
            thread.start();
        }
        for (int i = 0; i < 5; i++) {
            FutureTask<Integer> result = futureTaskList[i];
            try{
                System.out.println("Future Task " + i + " : " + result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        //4. Using the Executor Framework along with Runnable and Callable Tasks
        ExecutorService executors = Executors.newFixedThreadPool(5);
        Future<Integer>[] futureLists = new Future[5];
        Callable<Integer> workerCallable = new CallableTask();
        try{
            for(int i = 0; i < futureLists.length; i++){
                Future<Integer> future = executors.submit(workerCallable);
                futureLists[i] = future;
            }
            for(int i = 0; i < futureLists.length; i++){
                try {
                    System.out.println("Result from Future " + i + " : " + futureLists[i].get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {

                    e.printStackTrace();
                }
            }
        } finally {
            executors.shutdown();
        }
    }
}


/**
 * 1. Extending Thread Class
 */
class Worker extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

/**
 * 2. Implementing Runnable Interface
 */
class RunnableWorker implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

/**
 * 3. Implementing Callable Interface
 */
class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}

