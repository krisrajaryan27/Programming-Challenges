package com.nirvana.learning.javaeight.lambda.capturinglambda;

import java.util.function.UnaryOperator;

/**
 * A lambda expression is said to be capturing if it either accesses instance variables of
 * it’s enclosing class or local variables (final or effectively final) from it’s enclosing scope.
 * <p>
 * A lambda expression can capture the three types of variables given below:
 * <p>
 * Static variables
 * Instance variables
 * Local variables
 * <p>
 * If a lambda expression captures a local variable then the variable should be either final or effectively final.
 * <p>
 * Effectively final is a new concept that was introduced in Java 8.
 * A non-final, local variable whose value is never changed after initialization is known as effectively final.
 */
public class CapturingLambdaImpl {
    public static void main(String[] args) {
        //Here lambda is capturing a local variable called i.
        // The value of this variable is initialized once and never changed, so it is effectively final.
        int i = 5;
        UnaryOperator<Integer> operator = input -> input * i;
        System.out.println(operator.apply(i));
    }
}
