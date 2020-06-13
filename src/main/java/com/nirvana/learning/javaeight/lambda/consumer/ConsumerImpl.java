package com.nirvana.learning.javaeight.lambda.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Consumers are functional interfaces that take in a parameter and do not produce anything.
 * This interface takes a parameter of type T and does not return anything.
 * A consumer can be used in all contexts where an object needs to be consumed,i.e. taken as input,
 * and some operation is performed on the object without returning any result.
 * <p>
 * The andThen() method, which is a default method in the Consumer interface is used for chaining.
 * <p>
 * BiConsumer<T,U> #
 * This interface takes two parameters and returns nothing.
 * <p>
 * T - the type of the first argument to the operation
 * U - the type of the second argument to the operation.
 */
public class ConsumerImpl {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = s -> System.out.println(s);
        stringConsumer.accept("Hello World!");

        Consumer<Integer> integerConsumer = i -> System.out.println("Integer value = " + i);
        integerConsumer.accept(10);

        //The andThen() method, which is a default method in the Consumer interface is used for chaining

        Consumer<String> consumer1 = (arg) -> System.out.println(arg + "My name is Jane.");

        Consumer<String> consumer2 = (arg) -> System.out.println(arg + "I am from Canada.");

        consumer1.andThen(consumer2).accept("Hello! ");

        BiConsumer<String, String> greet = (s1, s2) -> System.out.println(s1 + s2);
        greet.accept("Hello", "World!");


    }
}
