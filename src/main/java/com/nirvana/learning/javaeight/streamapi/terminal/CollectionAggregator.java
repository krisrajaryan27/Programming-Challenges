package com.nirvana.learning.javaeight.streamapi.terminal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1. counting() - returns a Collector that counts the number of the input elements.
 * 2. Collectors.summingInt(ToIntFunction<? super T> mapper) - returns a Collector
 * that produces the sum of an integer-valued function applied to the input elements.
 * 3. Collectors.averagingInt(ToIntFunction<? super T> mapper) - returns a Collector
 * that produces the arithmetic mean of an integer-valued function applied to the input elements.
 * If no elements are present, the result is 0.
 * 4. minBy(Comparator<? super T> comparator) - returns a Collector that returns
 * the minimum element based on the given comparator.
 * 5. maxBy(Comparator<? super T> comparator) - returns a Collector that returns
 * the minimum element based on the given comparator.
 * 6. summarizingInt(ToIntFunction<? super T> mapper) - returns a Collector that
 * applies an int-producing mapping function to each input element and returns summary
 * statistics for the resulting values.
 * 7. joining() - returns a Collector that concatenates the input elements into a String,
 * in the encounter order. It also has few overloaded versions which allow us to provide
 * delimiters and prefix and suffix strings.
 */
public class CollectionAggregator {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000));
        employeeList.add(new Employee("Ben", 63, 25000));
        employeeList.add(new Employee("Dave", 34, 56000));
        employeeList.add(new Employee("Jodi", 43, 67000));
        employeeList.add(new Employee("Ryan", 53, 54000));

        //1. counting() - returns a Collector that counts the number of the input elements.
        long count = employeeList.stream()
                .filter(employee -> employee.getAge() > 23)
                .collect(Collectors.counting()); // Using the counting() method to get count of employees.

        System.out.println("No of employess whose age is greater than 23: " + count);

        //2. Collectors.summingInt(ToIntFunction<? super T> mapper) - returns a Collector
        // that produces the sum of an integer-valued function applied to the input elements.
        int totalSalaryDisbursed = employeeList.stream()
                .collect(Collectors.summingInt(Employee::getSalary));

        System.out.println("Total Salary disbursed to employees: " + totalSalaryDisbursed);

        //3. Collectors.averagingInt(ToIntFunction<? super T> mapper)
        // returns a Collector that produces the arithmetic mean of an integer-valued
        // function applied to the input elements. If no elements are present, the result is 0.

        double averageAgeOfEmployees = employeeList.stream()
                .collect(Collectors.averagingInt(Employee::getAge));

        System.out.println("Average age of the employees: " + averageAgeOfEmployees);

        //4. minBy(Comparator<? super T> comparator) - returns a Collector that returns
        // the minimum element based on the given comparator.

        Optional<Employee> lowestSalariedEmployee = employeeList.stream()
                .collect(Collectors.minBy(Comparator.comparingInt(Employee::getSalary)));

        lowestSalariedEmployee.ifPresent(employee -> System.out.println("Lowest salaried employee is: " + employee.getName() + " with salary: " + employee.getSalary()));

        //5. maxBy(Comparator<? super T> comparator) - returns a Collector that returns
        // the minimum element based on the given comparator.

        Optional<Employee> maxSalariedEmployee = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));

        maxSalariedEmployee.ifPresent(employee -> System.out.println("Max salaried employee is: " + employee.getName() + " with salary: " + employee.getSalary()));

        //6. summarizingInt(ToIntFunction<? super T> mapper) - returns a Collector that
        // applies an int-producing mapping function to each input element and returns summary
        // statistics for the resulting values.
        IntSummaryStatistics summarizingInt = Stream.of("1", "2", "3", "4")
                .collect(Collectors.summarizingInt(Integer::parseInt));

        System.out.println(summarizingInt);

        //7. joining() - returns a Collector that concatenates the input elements into a String,
        // in the encounter order. It also has few overloaded versions which allow us to provide
        // delimiters and prefix and suffix strings.

        String joinedString = Stream.of("Hello", "How", "are", "you", "?")
                .collect(Collectors.joining());

        System.out.println(joinedString);

        // Joining all the strings with space in between.
        joinedString = Stream.of("hello", "how", "are", "you")
                .collect(Collectors.joining(" "));
        System.out.println(joinedString);

        // Joining all the strings with space in between and a prefix and suffix.
        joinedString = Stream.of("hello", "how", "are", "you")
                .collect(Collectors.joining(" ", "prefix", "suffix"));
        System.out.println(joinedString);


    }
}
