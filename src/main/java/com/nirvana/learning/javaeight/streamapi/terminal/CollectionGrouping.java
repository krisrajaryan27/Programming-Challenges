package com.nirvana.learning.javaeight.streamapi.terminal;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * 1. Collectors.groupingBy() - groups the input elements according to the supplied classifier and returns the results in a Map.
 * a) groupingBy(Function<? super T, ? extends K> classifier) - takes only an instance of a Function interface as a parameter.
 * b) groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream) -
 * takes an additional second collector, which is applied to the results of the first collector.
 * c) groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream) -
 * it takes a supplier as an additional parameter.
 * d) groupingByConcurrent(Function<? super T,? extends K> classifier) - similar to the groupingBy() collector;
 * the only difference is that this method returns an instance of ConcurrentMap.
 * 2. Collectors.partitioningBy() - partitions the input elements according to the supplied Predicate
 * and returns a Map<Boolean, List<T>>.
 */
public class CollectionGrouping {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "China"));
        employeeList.add(new Employee("Dave", 34, 56000, "India"));
        employeeList.add(new Employee("Jodi", 43, 67000, "USA"));
        employeeList.add(new Employee("Ryan", 53, 54000, "China"));

        //1.groupingBy(Function<? super T, ? extends K> classifier) - takes only an instance of a Function interface as a parameter.
        // The employees are grouped by country using the groupingBy() method.
        Map<String, List<Employee>> employeeMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry));
        System.out.println(employeeMap);

        //2.groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream) -
        // takes an additional second collector, which is applied to the results of the first collector.
        Map<String, Set<Employee>> empMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry, Collectors.toSet()));
        System.out.println(empMap);

        // The employees are grouped by country and age by using the groupingBy() method twice.
        Map<String, Map<Integer, List<Employee>>> empGroupByCountryAndAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry, Collectors.groupingBy(Employee::getAge)));
        System.out.println(empGroupByCountryAndAge);

        //Map where the key is the name of the country and the value is the sum of salaries of all the employees of that country.
        Map<String, Integer> empGroupByCountryWithSalarySum = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry, Collectors.summingInt(Employee::getSalary)));

        System.out.println(empGroupByCountryWithSalarySum);

        //Map where the key is the name of the country and the value is the Employee object that has the max salary in that country
        Map<String, Optional<Employee>> empGroupByCountryWithMaxSalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));

        System.out.println(empGroupByCountryWithMaxSalary);

        //3.groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream) -
        //it takes a supplier as an additional parameter.
        HashMap<String, Set<Employee>> empCountrySet = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry, HashMap::new, Collectors.toSet()));

        System.out.println(empCountrySet);

        //4.groupingByConcurrent(Function<? super T,? extends K> classifier) - similar to the groupingBy() collector;
        // the only difference is that this method returns an instance of ConcurrentMap.

        ConcurrentMap<Integer, List<Employee>> empSalaryWise = employeeList.parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getSalary));

        System.out.println(empSalaryWise);

        //6. Collectors.partitioningBy() - partitions the input elements according to the supplied Predicate and returns a Map<Boolean, List<T>>.
        Map<Boolean, List<Employee>> empWithAgeMoreThanThirty = employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge() > 30));

        System.out.println(empWithAgeMoreThanThirty);


    }
}
