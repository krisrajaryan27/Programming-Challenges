package com.nirvana.learning.designpatterns.creational.singleton;

/**
 * @author KrishnaV on 11/11/19
 * @project Programming-Challenges
 */
public class RunTimeSingleton {
    public static void main(String[] args) {
        Runtime singletonRunTime = Runtime.getRuntime();
        singletonRunTime.gc();
        System.out.println(singletonRunTime);
        Runtime anotherInstance = Runtime.getRuntime();
        System.out.println(anotherInstance);
        if(singletonRunTime == anotherInstance){
            System.out.println("They are the same instance");
        }
    }
}
