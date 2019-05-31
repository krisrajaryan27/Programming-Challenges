package com.nirvana.learning.threadpool.service;

import com.nirvana.learning.threadpool.utils.MyMonitorThread;
import com.nirvana.learning.threadpool.utils.RejectedExecutionHandlerImpl;
import com.nirvana.learning.threadpool.utils.WorkerThread;

import java.util.concurrent.*;

public class WorkerPool {

    public static void main(String[] args) throws InterruptedException{
        RejectedExecutionHandlerImpl rejectedExecutionHandler = new RejectedExecutionHandlerImpl();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2,4,10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2),threadFactory,rejectedExecutionHandler);

        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        for(int i = 0; i<10; i++){
            executorPool.execute(new WorkerThread("cmd"+i));
        }

        Thread.sleep(30000);

        executorPool.shutdown();

        Thread.sleep(5000);
        monitor.shutdown();

    }


}
