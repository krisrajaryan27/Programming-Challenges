package com.nirvana.learning.javaeight.streamapi.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Mapping operations are those operations that transform the elements of a stream
 * and return a new stream with transformed elements.
 * Common Methods - map(), flatMap()
 * 1. map() - method takes a lambda expression as its only argument
 * and uses it to change every individual element in the stream.
 * Its return value is a new stream object containing the changed elements.
 * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
 * <p>
 * 2. flatMap() - Stream flatMap() method is used to flatten a stream of collections
 * to a stream of elements combined from all collections.
 * Basically, flatMap() is used to do following operation:
 * <p>
 * Stream<String[]> -> flatMap -> Stream<String>
 * <p>
 * Stream<Set<String>> -> flatMap -> Stream<String>
 * <p>
 * Stream<List<String>> -> flatMap -> Stream<String>
 * <p>
 * Why to flatten the stream? - The reason is that intermediate methods
 * such as filter() and distinct() do not work on streams of Collections.
 */
public class MappingOperations {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Krishna");
        list.add("Pooja");
        list.add("Rajat");
        list.add("Shubham");

        // map() is used to convert each name to upper case.
        // Note: The map() method does not modify the original list.
        list.stream()
                .map(name -> name.toUpperCase()) //map() takes an input of Function<T, R> type.
                .forEach(System.out::println);  // forEach() takes an input of Consumer type.

        //Given a list of words, we need to print the length of each word.
        list.stream()
                .mapToInt(name -> name.length())
                .forEach(System.out::println);

        List<List<String>> nestedList = new ArrayList<>();
        nestedList.add(Arrays.asList("a", "b", "c"));
        nestedList.add(Arrays.asList("d", "e", "f"));
        nestedList.add(Arrays.asList("g", "h", "i"));
        nestedList.add(Arrays.asList("j", "k", "l"));

        Stream<List<String>> stream = nestedList.stream();
        // filter() method do not work on stream of collections
        Stream<List<String>> listStream = stream.filter(x -> "a".equals(x.toString()));
        //This will not print anything
        listStream.forEach(System.out::println);

        //Flatten the stream
        Stream<String> stringStream = nestedList.stream().flatMap(strings -> strings.stream());
        //Applying filter to the flattened stringStream
        Stream<String> filteredStream = stringStream.filter(x -> "a".equals(x));
        filteredStream.forEach(System.out::println);

        nestedList.stream()
                .flatMap(s -> s.stream())
                .filter(x -> "a".equals(x))
                .forEach(System.out::println);


    }
}
