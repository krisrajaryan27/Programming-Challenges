package com.nirvana.learning.javaeight.streamapi.intermediate;

import com.nirvana.learning.javaeight.lambda.comparator.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * The filtering operations filters the given stream and returns a new stream,
 * which contains only those elements that are required for the next operation.
 */
public class FilteringOperation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(23);
        list.add(45);
        list.add(6);

        // Created a stream from the list
        //filter operation to get only numbers greater than 10
        // Printing each number in the list after filtering.
        list.stream()
                .filter(num -> num > 10)
                .forEach(System.out::println);

        //Again printing the elements of List to show that the original list is not modified.
        System.out.println("Original list is not modified");
        list.stream()
                .forEach(System.out::println);


        //Created a list of Person object.
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Dave", 23, "USA"));
        personList.add(new Person("Joe", 18, "USA"));
        personList.add(new Person("Ryan", 54, "USA"));
        personList.add(new Person("Iyan", 5, "USA"));
        personList.add(new Person("Ray", 63, "USA"));

        // We are filtering out those persons whose age is more than 18 and less than 60
        personList.stream()
                .filter(person -> person.getAge() > 15 && person.getAge() < 60)
                .forEach(System.out::println);

        personList.stream()
                .filter(person -> person.getName() != null) // Filtering the object where name is not null
                .filter(person -> person.getAge() > 8) // Filtering the objects where age is greater than 18
                .filter(person -> person.getAge() < 60) // Filtering the objects where age is less than 60
                .forEach(System.out::println);


    }
}
