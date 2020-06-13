package com.nirvana.learning.javaeight.streamapi.terminal;

import com.nirvana.learning.javaeight.lambda.comparator.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * There are two basic finding operations in streams, i.e., findFirst() and findAny().
 * These operations are typically used with a filter() operation,
 * but it is not necessary that they are used only with a filter() operation.
 * 1. Optional<T> findFirst() - returns an Optional describing the first element of this stream,
 * or an empty Optional if the stream is empty.
 * 2. Optional<T> findAny() - returns an Optional describing some element of this stream,
 * or an empty Optional if the stream is empty. This operation is particularly useful in
 * the case of parallel streams.
 */
public class FindingOperations {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Krishna", 27, "India"));
        personList.add(new Person("Ankita", 30, "India"));
        personList.add(new Person("Nag", 37, "USA"));
        personList.add(new Person("Sanjay", 38, "USA"));
        personList.add(new Person("Amar", 54, "UK"));
        personList.add(new Person("Maddie", 35, "Canada"));

        Optional<Person> person = personList.stream()
                .filter(p -> p.getCountry().equals("India"))
                .findFirst();
        person.ifPresent(System.out::println);

        Optional<Person> usaPerson = personList.stream()
                .filter(p -> p.getCountry().equals("USA"))
                .findAny();
        usaPerson.ifPresent(System.out::println);

    }
}
