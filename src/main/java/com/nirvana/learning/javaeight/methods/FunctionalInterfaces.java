package com.nirvana.learning.javaeight.methods;

/**
 * Functional Interface - An interface that has a single abstract method is called a functional interface.
 * While an interface can have one or more default methods,
 * it should have only one abstract method to be called a functional interface.
 * Java 8 has defined the java.util.function package, containing lots of functional interfaces.
 * Some functional interfaces defined in Java 8 are Predicate, Consumer, Supplier, Function, etc.
 */

@FunctionalInterface
interface Functional {
    void doSomething();

    default void foo() {
        System.out.println("Inside foo method");
    }
}

public class FunctionalInterfaces implements Functional {
    public static void main(String[] args) {
        FunctionalInterfaces functionalInterfaces = new FunctionalInterfaces();
        functionalInterfaces.doSomething();
        functionalInterfaces.foo();
    }

    @Override
    public void doSomething() {
        System.out.println("Inside the doSomething method");
    }
}
