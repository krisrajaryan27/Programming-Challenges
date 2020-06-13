package com.nirvana.learning.javaeight.streamapi.terminal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Immutable Reduction Through reduce()
 * Reduction stream operations into a single value.
 * Reduction Concepts:
 * i)Identity - an element that is the initial value of the reduction
 * operation and the default result if the stream is empty.
 * <p>
 * ii)Accumulator – a function that takes two parameters:
 * a partial result of the reduction operation and the next element of the stream.
 * <p>
 * iii)Combiner – a function used to combine the partial result of the reduction operation when
 * the reduction is parallelized. or there’s a mismatch between the types of the accumulator
 * arguments and the types of the accumulator implementation.
 * <p>
 * 1. Optional<T> reduce(BinaryOperator<T> accumulator) #
 * The reduce() method iteratively applies the accumulator function on the current input element.
 * <p>
 * 2. T reduce(T identity, BinaryOperator<T> accumulator)
 * This method has an extra ‘identity’ parameter. It is the initial value of reduction.
 * It is the default result of reduction if there are no elements in the stream.
 * That’s the reason, this version of reduce method doesn’t return Optional
 * because it would at least return the identity element.
 * <p>
 */
public class ImmutableReductionOperations {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Dave", 23, 20000));
        list.add(new Employee("Joe", 18, 40000));
        list.add(new Employee("Ryan", 54, 100000));
        list.add(new Employee("Iyan", 5, 34000));
        list.add(new Employee("Ray", 63, 54000));

        Optional<Integer> totalSalary = list.stream()
                .map(p -> p.getSalary())  //We are converting the Stream of Employees to Stream of salaries.
                .reduce((p, q) -> p + q);

        if (totalSalary.isPresent()) {
            System.out.println("The total salary is " + totalSalary.get());
        }

        int salaryTotal = list.stream()
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println("Total Salary: " + salaryTotal);

        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        numList.add(6);

        int totalSum = numList.stream()
                .reduce(5, Integer::sum);
        System.out.println("Total Sum: " + totalSum);

        Optional<Integer> max = numList.stream()
                .max(Comparator.naturalOrder());
        max.ifPresent(val -> System.out.println("Max Value: " + val));

        Optional<Integer> min = numList.stream()
                .min(Comparator.naturalOrder());

        System.out.println("Min value is " + min.get());

    }
}

class Employee {
    String name;
    int age;
    int salary;
    String country;

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, int age, int salary, String country) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", country='" + country + '\'' +
                '}';
    }
}


