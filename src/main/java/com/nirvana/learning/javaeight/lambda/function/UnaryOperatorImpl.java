package com.nirvana.learning.javaeight.lambda.function;

import com.nirvana.learning.javaeight.lambda.comparator.Person;

import java.util.function.UnaryOperator;

/**
 * The UnaryOperator<T> interface represents a function that takes one argument of type T
 * and returns a value of the same type.
 * This is similar to the Function interface, which is a parent to the UnaryOperator interface.
 * <p>
 * The UnaryOperator does not define any new abstract methods. Since it extends
 * the Function interface from the same package, it inherits the following method from the Function interface :
 * T apply(T t)
 */
public class UnaryOperatorImpl {
    public static void main(String[] args) {
        Person person = new Person();
        UnaryOperator<Person> operator = p -> {
            p.setName("Chris Hemsworth");
            p.setAge(34);
            p.setCountry("Australia");
            return p;
        };
        operator.apply(person);
        System.out.println("Person Name: " + person.getName() + "\nPerson Age: " + person.getAge() + "\nPerson Country: " + person.getCountry());
    }
}
