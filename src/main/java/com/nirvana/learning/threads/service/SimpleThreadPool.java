package com.nirvana.learning.threads.service;

import com.nirvana.learning.threads.creation.ChildThread;
import com.nirvana.learning.threads.utils.WorkerThread;

import java.util.concurrent.*;

/**
 * Creating a running thread is an expensive operation, and an operating system may limit the number of threads
 * provided to a running application at any one time.
 * By using a thread pool, you can create threads when needed, and, rather than creating new threads, you can
 * reuse a thread after it has completed running previous code.
 */
public class SimpleThreadPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Hello World!"));
        ((ExecutorService) executor).shutdown();

        Executor cachedExecutor = Executors.newCachedThreadPool();
        cachedExecutor.execute(new ChildThread());
        cachedExecutor.execute(new ChildThread());
        cachedExecutor.execute(new ChildThread());

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> "Hello World");
        String result = future.get();
        System.out.println(result);


        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executorService.execute(worker);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }

        System.out.println("Finished all the threads!");
    }
}
