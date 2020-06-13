package com.nirvana.learning.javaeight.streamapi.terminal;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Mutable reductions collect the desired results into a mutable container object,
 * such as a java.util.Collection or an array. The mutable reduction is achieved
 * through the collect() method. It is one of the Stream API‘s terminal methods.
 * There are two overloaded versions of the collect() method:
 * <p>
 * collect(Collector<? super T,A,R> collector)
 *
 * <R> R collect(Supplier&lt;R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
 */
public class MutableReductionOperations {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "India"));
        employeeList.add(new Employee("Dave", 34, 56000, "Bhutan"));
        employeeList.add(new Employee("Jodi", 43, 67000, "China"));
        employeeList.add(new Employee("Ryan", 53, 54000, "Libya"));
        employeeList.add(new Employee("Prabho", 53, 54000, "Libya"));

        //1. Collectors.toList()
        List<String> empNames = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(empNames);

        //2. Collectors.toSet()
        Set<String> empCountries = employeeList.stream()
                .map(Employee::getCountry)
                .collect(Collectors.toSet());
        System.out.println(empCountries);

        //3. Collectors.toCollection(Supplier<C> collectionFactory)
        LinkedList<String> empName = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(empName);

        //4. Collectors.toMap()
        List<String> list = new ArrayList<>();
        list.add("done");
        list.add("far");
        list.add("away");
        list.add("again");
//        list.add("again");

        Map<String, Integer> nameMap = list.stream()
                .collect(Collectors.toMap(s -> s, String::length, (s1, s2) -> s1, HashMap::new)); //to avoid duplicate key (s1,s2)->s1

        System.out.println(nameMap);

    }
}
