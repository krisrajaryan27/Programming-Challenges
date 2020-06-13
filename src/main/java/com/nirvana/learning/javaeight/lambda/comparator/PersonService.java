package com.nirvana.learning.javaeight.lambda.comparator;

import java.util.Collections;
import java.util.List;

public class PersonService {
    public static List<Person> getPersons(List<Person> persons) {
        // Created an anonymous Comparator, which sorts the Person object on the basis of Person name.
       /* Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/

        //Using lambdas for Comparator Interface as it is a Functional Interface with 1 abstract method
        Collections.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        //Using Method Reference
        //Collections.sort(persons, Comparator.comparing(Person::getName));
        return persons;
    }
}
