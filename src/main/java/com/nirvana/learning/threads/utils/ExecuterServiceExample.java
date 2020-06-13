package com.nirvana.learning.threads.utils;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author KrishnaV
 */
public class ExecuterServiceExample {
    public static void main(String... args) {
        ScheduledExecutorService timer =
                Executors.newSingleThreadScheduledExecutor();
        timer.scheduleAtFixedRate(
                () -> System.out.println(LocalTime.now()),
                0, 1, TimeUnit.SECONDS
        );
        timer.scheduleAtFixedRate(
                () -> System.out.println("Hello World"),
                0, 200, TimeUnit.MILLISECONDS
        );
        System.out.println("Main Thread: I'm outta here!");
    }
}
