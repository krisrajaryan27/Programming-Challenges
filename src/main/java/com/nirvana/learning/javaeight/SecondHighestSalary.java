package com.nirvana.learning.javaeight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
class Employee {
    int id;
    String firstName;
    String lastName;
    int age;
    int deptId;
    int salary;
}

public class SecondHighestSalary {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Krishna", "Verma", 31, 123, 20000),
                new Employee(2, "Pooja", "Verma", 27, 124, 12000),
                new Employee(3, "Sukhram", "Verma", 55, 125, 50000),
                new Employee(4, "Savitri", "Verma", 50, 126, 35000));

        try {
            Employee employeeWithSecondHighestSalary = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().orElseThrow(() -> new Exception("Second Highest Salary not found"));
            System.out.println("Employee with second highest salary: " + employeeWithSecondHighestSalary);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
