#### What is a Thread?
A Thread is a lightweight Process. Any Process can have multiple Threads running in it.

For example in a web browser, we can have one thread Which will load the User Interface and we can have one more thread which will actually retrive all the data that needs to be displayed in the User Interface.

#### What is MultiThreading?
Multithreading enables us to run Multiple Threads Concurrently.

For example in a web browser, we can have on thread which handles the User Interface and in Parallel we can have one more thread which is fetching the data to be displayed.

So multithreading improves the responsiveness of a System.

####What is Concurrency?
Concurrency in the Context of Threads enables us to run multiple Threads at the same time.

But do the Threads Really run at the same time?

Single Core Systems
The Thread Scheduler provided by the JVM decides which Thread runs at any given time. The scheduler gives a small time slice to each Thread.

So at any given time we have only thread which is actually running in the processor. But because of the time slicing we get the feeling that multiple threads are running at the same time.

Multi Core Systems
Even in Multiple Core systems the thread scheduler is involved. But since we have multiple cores, we can actually have multiple threads running at the exact same time.

For example if we have a dual core system, then we can have 2 threads running at the exact same time. The first thread will run in the first core, and the second thread will run in the second core.

####Why is Multithreading needed?
Multithreading enables us to improve the responsiveness of a System.

For example in a web browser, if everything ran in a single Thread, then system will be completely unresponsive whenever data is being fetched to display. If it takes 10 seconds to fetch the data, then in that 10 seconds we wont be able to do anything else in the web browser like opening new tabs, or even closing the web browser.

So running different parts of a program in different threads concurrently helps improve the responsiveness of a system.

####How to write Multithreaded Programs in Java?
We can create Threads in java using the following

 - Extending the Thread Class
 - Implementing the Runnable Interface
 - Implementing the Callable Interface
 - By using the Executor Framework along with Runnable and Callable Tasks

#####Extending the Thread Class
In order to create a Piece of code which can be run in a Thread, we create a class and then extend the Thread class. The task being done by this piece of code needs to be put in the run() function. In the below code you can see that Worker is a class which extends Thread Class, and the task of printing numbers 0 to 5 is being done inside the run() function.

    class Worker extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

In the Above code Thread.currentThread().getName() is used to get the name of the Current Thread which is running the code.

In order to create a Thread, we just need to create an instance of the Worker class. And then we can start the Thread using the start() function.

    public class ThreadClassDemo {
        public static void main(String[] args) {
            Thread t1 = new Worker();
            Thread t2 = new Worker();
            Thread t3 = new Worker();
            t1.start();
            t2.start();
            t3.start();
    
        }
    }
In the Above code, we are creating 3 threads t1,t2 and t3 from the Worker class. Then we are starting the threads using the start() function.

Here is the Final Code for Creating a thread by Extending a Thread class

    class Worker extends Thread {
    
        @Override
        public void run() {
            for (int i = 0; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    
    }

    public class ThreadClassDemo {
        public static void main(String[] args) {
            Thread t1 = new Worker();
            Thread t2 = new Worker();
            Thread t3 = new Worker();
            t1.start();
            t2.start();
            t3.start();
    
        }
    }

It can be seen clearly from the output that the 3 threads do not run in any particular sequence

####Implementing the Runnable Interface
In order to create a Piece of code which can be run in a Thread, we create a class and then implement the Runnable Interface. The task being done by this piece of code needs to be put in the run() function. In the below code you can see that RunnableWorker is a class which implements Runnable Interface, and the task of printing numbers 0 to 4 is being done inside the run() function.

In order to create a Thread, first we need to create an Instance of RunnableWorker which implements the Runnable Interface.

Then we can create a new thread by creating an instance of Thread class and passing the Instance of RunnableWorker as the Argument. This is shown in the code below

    public class RunnableInterfaceDemo {
        class RunnableWorker implements Runnable{
        
            @Override
            public void run() {
                for (int i = 0; i <= 4; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
            
        }
        public static void main(String[] args) {
            Runnable r = new RunnableWorker();
            Thread t1 = new Thread(r);
            Thread t2 = new Thread(r);
            Thread t3 = new Thread(r);
            
            t1.start();
            t2.start();
            t3.start();
    
        }
    
    }
The above code creates a Runnable Instance r. Then it create 3 threads t1, t2 and t3 and passes r as the argument to the 3 threads. Then the start() function is used to start all the 3 threads.

Here is the complete Code for creating a Thread by Implementing the Runnable Interface

    class RunnableWorker implements Runnable{
    
        @Override
        public void run() {
            for (int i = 0; i <= 4; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
        
    }

    public class RunnableInterfaceDemo {
    
        public static void main(String[] args) {
            Runnable r = new RunnableWorker();
            Thread t1 = new Thread(r);
            Thread t2 = new Thread(r);
            Thread t3 = new Thread(r);
            
            t1.start();
            t2.start();
            t3.start();
    
        }
    
    }
On Running the Above code, we will get the following output. The sequence of the output will change everytime the code is run.

Runnable Interface output

Implementing the Runnable Interface is a better option than extending the Thread class since we can extend only one class, but we can implement multiple interfaces in java.

###Runnable Interface in Java 8
In java 8, the Runnable Interface becomes a FunctionalInterface since it has only one function run().

The below code shows how we can create a Runnable Instance in java 8.

    public class RunnableFunctionalInterfaceDemo {
    
        public static void main(String[] args) {
            
            Runnable r = () -> {
                for (int i = 0; i <= 4; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            };
            
            Thread t1 = new Thread(r);
            Thread t2 = new Thread(r);
            Thread t3 = new Thread(r);
            
            t1.start();
            t2.start();
            t3.start();
        }
    
    }
Here instead of creating a class and then implementing Runnable Interface, we can directly use lambda expression to create a Runnable Instance as shown below
	
		Runnable r = () -> {
			for (int i = 0; i <= 4; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
			}
		};

###Implementing the Callable Interface
In order to create a Piece of code which can be run in a Thread, we create a class and then implement the Callable Interface. The task being done by this piece of code needs to be put in the call() function. In the below code you can see that CallableTask is a class which implements Callable Interface, and the task of summing up numbers from 0 to 4 is being done in the function.

    import java.util.concurrent.Callable;
    class CallableTask implements Callable<Integer> {
    
        @Override
        public Integer call() throws Exception {
    
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += i;
            }
            return sum;
        }
    
    }
In the above code you would notice that Callable has a parameter of Integer. This shows that the return type of this Callable will be Integer. Also it can be seen that the call function returns Integer type.

####Creating the Threads and running them
The code below shows how to create the Threads and then run them.

    import java.util.concurrent.ExecutionException;
    import java.util.concurrent.FutureTask;
    public class CallableInterfaceDemo {
    
        public static void main(String[] args) {
            FutureTask<Integer>[] futureList = new FutureTask[5];
    
            for (int i = 0; i <= 4; i++) {
                Callable<Integer> callable = new CallableTask();
                futureList[i] = new FutureTask<Integer>(callable);
                Thread t = new Thread(futureList[i]);
                t.start();
    
            }
    
            for (int i = 0; i <= 4; i++) {
                FutureTask<Integer> result = futureList[i];
                try {
                    System.out.println("Future Task" + i + ":" + result.get());
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    
                    e.printStackTrace();
                }
            }
    
        }
    
    }
In order to create a Thread, first we need to create an Instance of CallableTask which implements the Callable Interface as shown in

    Callable<Integer> callable = new CallableTask();
Then we need to create an Instance of the FutureTask class and pass the instance of Callable task as an argument as shown in

    futureList[i] = new FutureTask<Integer>(callable);
Then to create a Thread we create an instance of the Thread class and pass the Instance of the FutureTask class as an argument as shown in

    Thread t = new Thread(futureList[i]);
Finally the Thread is started with the start() function.

Getting the result from the Thread
In case of Callables the Thread can actually return a value. In order to get this value we can call the get() function on the instance of the FutureTask. In our code, the return value of the thread is the sum of numbers from 0 to 4.

This is shown in the below code snippet

    FutureTask<Integer> result = futureList[i];
    try {
        System.out.println("Future Task" + i + ":" + result.get());
    } catch (InterruptedException e) {
                    
        e.printStackTrace();
    } catch (ExecutionException e) {
                    
        e.printStackTrace();
    }
Also the thread may throw an Exception as well which can be handled with try catch blocks.

Complete Code
Here is the complete code discussed till now

    import java.util.concurrent.Callable;
    import java.util.concurrent.ExecutionException;
    import java.util.concurrent.FutureTask;
    
    class CallableTask implements Callable<Integer> {
    
        @Override
        public Integer call() throws Exception {
    
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += i;
            }
            return sum;
        }
    
    }
    
    public class CallableInterfaceDemo {
    
        public static void main(String[] args) {
            FutureTask<Integer>[] futureList = new FutureTask[5];
    
            for (int i = 0; i <= 4; i++) {
                Callable<Integer> callable = new CallableTask();
                futureList[i] = new FutureTask<Integer>(callable);
                Thread t = new Thread(futureList[i]);
                t.start();
    
            }
    
            for (int i = 0; i <= 4; i++) {
                FutureTask<Integer> result = futureList[i];
                try {
                    System.out.println("Future Task" + i + ":" + result.get());
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    
                    e.printStackTrace();
                }
            }
    
        }
    
    }
###The Executor Framework
Creating a Thread on the Fly everytime is Resource Intensive. One good alternative for this is to have some Threads already setup and then allocate our tasks to these threads. This is where the Executors Class and ExecutorService are very useful.

ThreadPool

A Thread pool with 4 threads

The above image shows a Thread pool with 4 threads. Whenever we want any task to be run, we can assign it to these threads. Once the task is complete, the Thread will be freed to take up other tasks.

How to use the Executor Framework
Here is a code which uses the Executor framework.

    import java.util.concurrent.Callable;
    import java.util.concurrent.ExecutionException;
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;
    import java.util.concurrent.Future;
    
    class Worker implements Callable<Integer> {
    
        @Override
        public Integer call() throws Exception {
    
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += i;
            }
            return sum;
        }
    
    }
    
    public class ExecutorDemo {
    
        public static void main(String[] args) {
            ExecutorService executors = Executors.newFixedThreadPool(4);
            Future<Integer>[] futures = new Future[5];
            Callable<Integer> w = new Worker();
            try {
                for (int i = 0; i < 5; i++) {
                    Future<Integer> future = executors.submit(w);
                    futures[i] = future;
    
                }
    
                for (int i = 0; i < futures.length; i++) {
                    try {
                        System.out.println("Result from Future " + i + ":" + futures[i].get());
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

First we create a Worker Class which implements Callable and does the task which we need.

Next we need to create an ExecutorService.

The Executors class has multiple implementations of the ExecutorService.

Let us use the Executors class to create a fixed Thread pool of size 4. This is done as follows

    ExecutorService executors = Executors.newFixedThreadPool(4);
Next we need to submit our task to the Executor Service. This is done using the following Line of code

    Future<Integer> future = executors.submit(w);
On submitting the task we get an Instance of the Future Object. The Future Object is what will store the result of the Task.

Getting the result of the Thread
In order to get the result of each task, we can call the get() method of the Future Instance. This is shown in the below code snippet.

    try {
        System.out.println("Result from Future " + i + ":" + futures[i].get());
    } catch (InterruptedException e) {
    
        e.printStackTrace();
    } catch (ExecutionException e) {
    
        e.printStackTrace();
    }
The thread can also Throw an Exception which can be handled using try catch.

Some possible Scenarios of the Fixed Thread Pool
In this example we created a fixed Thread pool of size 4
If we submit a total of 3 tasks to this ExecutorService, then all 3 tasks will be assigned to the thread pool and they will start executing.
If we submit 4 tasks to this ExecutorService, then again all 4 tasks will be assigned to the thread pool and they will start executing.
Now if we submit 5 tasks to this thread pool. Only 4 of the tasks will be assigned to the thread pool. This is because the size of the Thread pool is 4. The 5th Task will be assigned only when one of the threads in the pool gets freed
Shutting down the ExecutorService
The ExecutorService needs to be shutdown when the threads are not needed anymore. This will ensure that the JVM is not consuming Additional Resources.

The ExecutorService can be shutdown using the following command

    executors.shutdown();
It can be seen that this shutdown is put within the finally block. This is to ensure that the shutdown is always executed at the end of the code even if any exception occured.

If the shutdown is not done in the right way, then in case any exception occurs then the ExecutorService will still be running and will be consuming Additional JVM resources.