package com.nirvana.learning.javaeight.lambda.predicate;

import com.nirvana.learning.javaeight.lambda.comparator.Person;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * The Predicate<T> interface has an abstract method boolean test(T t).
 * Basically, a predicate is a function that evaluates the given input and returns true or false
 */
public class PredicateImpl {
    static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }

    static boolean isPersonElgibleForDriving(Person person, int minAge, BiPredicate<Person, Integer> biPredicate) {
        return biPredicate.test(person, minAge);
    }

    public static void main(String[] args) {
        Person person = new Person("Alex", 20, "UK");
        // Created a predicate. It returns true if age is greater than 18.
        Predicate<Person> greaterThanEighteen = p -> p.getAge() > 18;

        // Created a predicate. It returns true if age is less than 60.
        Predicate<Person> lessThanSixty = p -> p.getAge() < 60;

        //1. and(Predicate other) - returns a composed predicate that represents a short-circuiting logical AND
        // of this predicate and another
        Predicate<Person> agePedicate = greaterThanEighteen.and(lessThanSixty);

        //2. or(Predicate other) - returns a composed predicate that represents a short-circuiting logical OR
        // of this predicate and another.
        Predicate<Person> countryPredicate = p -> p.getCountry().equals("UK");

        Predicate<Person> predicate = agePedicate.or(countryPredicate);

        boolean isEligible = isPersonEligibleForVoting(person, predicate);
        System.out.println("Person: " + person.getName() + " is eligible for Voting: " + isEligible);

        BiPredicate<Person, Integer> biPredicate = (p, minAge) -> p.getAge() > minAge;
        boolean isElgibleForDriving = isPersonElgibleForDriving(person, 21, biPredicate);

        System.out.println("Person: " + person.getName() + " is eligible for Driving: " + isElgibleForDriving);


    }
}
