package com.nirvana.learning.javaeight.lambda.comparator;

import java.util.ArrayList;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Krishna", 26, "India"));
        personList.add(new Person("Pooja", 24, "India"));
        personList.add(new Person("Vivek", 24, "Nepal"));
        personList.add(new Person("Rajat", 22, "India"));
        personList.add(new Person("Shubham", 19, "India"));
        personList.add(new Person("Siddharth", 20, "Nepal"));

        List<Person> sortedPersons = PersonService.getPersons(personList);
        System.out.println("Persons after Sorting...");
        for (Person person : sortedPersons) {
            System.out.println("Person Name: " + person.getName());
        }

    }
}
