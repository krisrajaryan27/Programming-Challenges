package com.nirvana.learning.javaeight.lambda.supplier;

import com.nirvana.learning.javaeight.lambda.comparator.Person;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Supplier is an interface that does not take in any argument but produces a value when the get() function is invoked.
 * Suppliers are useful when we don’t need to supply any value and obtain a result at the same time.
 * The Supplier<T> interface supplies a result of type T
 * The Supplier<T> interface does not contain any default or static methods
 */
public class SupplierImpl {
    static boolean isPersonEligibleForVoting(Supplier<Person> supplier, Predicate<Person> predicate) {
        return predicate.test(supplier.get());
    }

    public static void main(String[] args) {
        Supplier<Person> supplier = () -> new Person("Jenny", 17, "USA");
        Predicate<Person> predicate = p -> p.getAge() > 18;
        boolean isEligibleForVoting = isPersonEligibleForVoting(supplier, predicate);
        System.out.println("Person: " + supplier.get().getName() + " is eligible for Voting: " + isEligibleForVoting);
    }
}
