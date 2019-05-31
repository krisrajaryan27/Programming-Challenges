package com.nirvana.learning.threadpool.service;

import com.nirvana.learning.threadpool.utils.WorkerThread;

import java.util.concurrent.*;

public class SimpleThreadPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
      /*  Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(()-> System.out.println("Hello World!"));
        ((ExecutorService) executor).shutdown();*/

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        /*Future<String> future = executorService.submit(()->"Hello World");
        String result = future.get();
        System.out.println(result);*/


        for (int i = 0; i<10;i++){
            Runnable worker = new WorkerThread("" +i);
            executorService.execute(worker);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()){

        }

        System.out.println("Finished all the threads!");
    }
}
