package com.nirvana.learning.designpatterns.creational.singleton;

/**
 * @author KrishnaV on 11/11/19
 * @project Programming-Challenges
 */
public class DbSingletonDemo {
    public static void main(String[] args) {
        DbSingleton instance = DbSingleton.getInstance();
        DbSingleton anotherInstance = DbSingleton.getInstance();
        System.out.println(instance);
        System.out.println(anotherInstance);
    }
}
