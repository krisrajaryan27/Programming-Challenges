package com.nirvana.learning.javaeight.lambda.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Function is a category of functional interfaces that takes an object of type T and returns an object of type R.
 * Function<T, R>
 * The function takes only one argument of type T and returns a result of type R.
 * <p>
 * 1. R apply(T t)
 * This is the abstract method of the Function interface. It takes one argument of type T as input and returns a value of type R
 * <p>
 * 2. compose(Function<? super V, ? extends T> before)
 * Returns a composed function that first applies the function provided as a parameter on the input,
 * and then applies the function on which it is called, to the result.
 * <p>
 * 3. andThen(Function<? super R,? extends V> after)
 * This method returns a composed function that first applies the function on which it is called on the input,
 * and then applies the function provided as parameter, to the result.
 * <p>
 * 4. BiFunction<T,U,R>
 * The BiFunction<T, U, R> is similar to Function<T, R> interface;
 * the only difference is that the BiFunction interface takes in two parameters and returns an output
 */
public class FunctionImpl {
    public static void main(String[] args) {
        // Created a function which returns the length of string.

        Function<String, Integer> lengthFunction = str -> str.length();
        System.out.println("String length: " + lengthFunction.apply("This is something very awesome!"));

        // Function which adds 10 to the given element.
        Function<Integer, Integer> increment = x -> x + 10;

        // Function which doubles the given element.
        Function<Integer, Integer> multiply = y -> y * 2;

        // Since we are using compose(), multiplication will be done first and then increment will be done.
        System.out.println("compose() Result: " + increment.compose(multiply).apply(3));

        // Since we are using andThen(), increment will be done first and then multiplication will be done.
        System.out.println("andThen() Result: " + increment.andThen(multiply).apply(3));


        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x * y;
        System.out.println("Product of 17 and 16 is: " + biFunction.apply(17, 16));

    }
}
