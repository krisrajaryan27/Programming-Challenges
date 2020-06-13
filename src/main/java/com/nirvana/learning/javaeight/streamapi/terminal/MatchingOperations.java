package com.nirvana.learning.javaeight.streamapi.terminal;

import com.nirvana.learning.javaeight.lambda.comparator.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Matching operations are terminal operations that are used to
 * check if elements with certain criteria are present in the stream or not.
 * There are mainly three matching functions available in Stream. These are:
 * 1. boolean anyMatch(Predicate<? super T> predicate)
 * 2. boolean allMatch(Predicate<? super T> predicate)
 * 3. boolean noneMatch(Predicate<? super T> predicate)
 */
public class MatchingOperations {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Krishna", 27, "India"));
        personList.add(new Person("Ankita", 30, "India"));
        personList.add(new Person("Nag", 37, "USA"));
        personList.add(new Person("Amar", 54, "UK"));
        personList.add(new Person("Maddie", 35, "Canada"));

        boolean anyCanadian = personList.stream()
                .anyMatch(person -> person.getCountry().equals("Canada"));
        System.out.println("Is there any Canadian: " + anyCanadian);

        boolean allCanadian = personList.stream()
                .allMatch(person -> person.getCountry().equals("Canada"));
        System.out.println("Are all Canadians: " + allCanadian);

        boolean noneRussian = personList.stream()
                .noneMatch(person -> person.getCountry().equals("Russia"));
        System.out.println("Are all persons not from Russia: " + noneRussian);


    }
}
