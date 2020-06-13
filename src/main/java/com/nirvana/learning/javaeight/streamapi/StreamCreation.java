package com.nirvana.learning.javaeight.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream - sequence of elements from a source that support aggregate operations on them.
 * It is not a data structure, bunch of operations applied to a source.
 * Source - Collections, Arrays or IO channels
 * Stream doesn't change the original data structure.
 * 0 or more intermediate operations that transforms a stream into another.
 * Each intermediate operation is lazily executed.
 * Terminal operation produces the result of the stream.
 * <p>
 * Stream Creation:
 * 1. Stream.of(v1,v2...)
 * 2. List.stream()
 * <p>
 * Intermediate Operations : It does not produce any result. They usually accept functional interfaces as parameters
 * Terminal Operations:
 * 1. filtering
 * 2. slicing
 * 3. mapping
 * 4. matching and finding
 * 5. reduction
 * 6. collect
 */
public class StreamCreation {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        stream.forEach(p -> System.out.println(p));

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        Stream<String> stringStream = list.stream();
        stringStream.forEach(str -> System.out.println(str));

    }
}
