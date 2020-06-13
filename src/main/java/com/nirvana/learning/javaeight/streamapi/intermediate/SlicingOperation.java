package com.nirvana.learning.javaeight.streamapi.intermediate;

import java.util.ArrayList;
import java.util.List;

/**
 * Slicing Operation - Intermediate operation, to slice the stream.
 * 1. distinct() - returns a stream consisting of the distinct elements
 * (according to Object.equals(Object)) of this stream.
 * So, if you have a stream of custom objects then your custom class should override equals() and hashcode() methods
 * <p>
 * 2. limit() - returns a stream consisting of the elements of this stream,
 * truncated to be no longer than maxSize in length.
 * Stream<T> limit(long maxSize)
 * <p>
 * 3. skip() - returns a stream consisting of the remaining elements of this stream
 * after discarding the first n elements of the stream.
 * Stream<T> skip(long n)
 */
public class SlicingOperation {
    public static void main(String[] args) {
        List<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("India");
        countries.add("Nepal");
        countries.add("China");
        countries.add("Australia");
        countries.add("Australia");
        countries.add("USA");
        countries.add("UK");
        countries.add("France");
        countries.add("France");

        countries.stream()
                .distinct()
                .limit(5)
                .forEach(System.out::println);

        countries.stream()
                .distinct()
                .skip(2)
                .forEach(System.out::println);


    }
}
