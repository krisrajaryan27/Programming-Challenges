package com.nirvana.learning.javaeight.methods;

interface InterfaceA {
    default void printSomething() {
        System.out.println("Printing inside default method of InterfaceA");
    }
}

interface InterfaceB {
    default void printSomething() {
        System.out.println("Printing inside default method of InterfaceA");
    }
}

/**
 * The below class will not compile because of the Diamond problem in Java.
 * To resolve the compilation issue, we will have to implement the printSomething()
 */
public class DefaultMethodsTwo implements InterfaceA, InterfaceB {
    public static void main(String[] args) {
        DefaultMethodsTwo defaultMethodsTwo = new DefaultMethodsTwo();
        defaultMethodsTwo.printSomething();
    }

    @Override
    public void printSomething() {
        System.out.println("Inside the Implementation class method");
        InterfaceA.super.printSomething();
        InterfaceB.super.printSomething();
    }
}
