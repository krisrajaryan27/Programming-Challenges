package com.nirvana.learning.designpatterns.creational.builder;

/**
 * @author KrishnaV on 11/11/19
 * @project Programming-Challenges
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("This is an example ");
        stringBuilder.append("of the builder pattern. ");
        stringBuilder.append("It has methods to append ");
        stringBuilder.append("almost anything we want to a String. ");
        stringBuilder.append(42);
        System.out.println(stringBuilder.toString());
    }
}
