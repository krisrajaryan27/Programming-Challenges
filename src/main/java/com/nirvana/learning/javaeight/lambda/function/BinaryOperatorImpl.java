package com.nirvana.learning.javaeight.lambda.function;

import com.nirvana.learning.javaeight.lambda.comparator.Person;

import java.util.function.BinaryOperator;

/**
 * BinaryOperator<T> is a functional interface that inherits from BiFunction<T, T, T> interface.
 * The BinaryOperator<T> interface takes only one parameter as compared to BiFunction<T, T, T>,
 * which takes three parameters.
 * <p>
 * Both the input objects and the result are of the same type in BinaryOperator<T>.
 */
public class BinaryOperatorImpl {
    public static void main(String[] args) {
        Person person1 = new Person("Chris Evans", 36, "UK");
        Person person2 = new Person("Samuel L. Jackson", 54, "USA");
        BinaryOperator<Person> binaryOperator = (p1, p2) -> {
            p1.setName(p2.getName());
            p1.setAge(p2.getAge());
            p1.setCountry(p2.getCountry());
            return p1;
        };
        binaryOperator.apply(person1, person2);
        System.out.println("Person Name: " + person1.getName() + "\nPerson Age: " + person1.getAge() + "\nPerson Country: " + person1.getCountry());
        System.out.println("Person Name: " + person2.getName() + "\nPerson Age: " + person2.getAge() + "\nPerson Country: " + person2.getCountry());
    }
}
