package com.nirvana.learning.javaeight.streamapi;

import java.util.ArrayList;
import java.util.List;

/**
 * Method References - references to a method.
 * Four kinds of method references #
 * 1. Static methods #
 * The syntax to use static methods as method reference is ClassName::MethodName.
 * 2. Instance method of a particular object #
 * The syntax to use the instance method as a method reference is ReferenceVariable::MethodName
 * 3. Instance method of an arbitrary object #
 * This type of method reference does not require the object of the referenced class.
 * 4. Constructor references #
 * We can refer to a constructor in the same way we reference a static method.
 * The only difference is that we need to use a new keyword.
 */
public class MethodReferences {
    public static int getLength(String str) {
        return str.length();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Krishna");
        list.add("Pooja");
        list.add("Rajat");
        list.add("Shubham");
        list.add("Adarsh");

        //1. Static Method References
        // Code without using method reference.
        list.stream()
                .map(name -> MethodReferences.getLength(name))
                .forEach(System.out::println);

        //Code with method references
        list.stream()
                .map(MethodReferences::getLength)
                .forEach(System.out::println);

        //2. Instance method of a particular object
        MethodReferences methodReferences = new MethodReferences();

        list.stream()
                .map(methodReferences::getUpperString)
                .forEach(System.out::println);


        //3. Instance method of an arbitrary object
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 50000, 27));
        employeeList.add(new Employee("Rachel", 70000, 23));
        employeeList.add(new Employee("Michael", 24000, 22));

        //Code without method references
        employeeList.stream()
                .mapToInt(emp -> emp.getSalary())
                .forEach(System.out::println);

        //Code with method references
        employeeList.stream()
                .mapToInt(Employee::getSalary)
                .forEach(System.out::println);

        //4. Constructor references
        //Code without method references
        list.stream()
                .map(name -> new Employee(name))
                .forEach(System.out::println);

        //Code with method reference
        list.stream()
                .map(Employee::new)
                .forEach(System.out::println);


    }

    public String getUpperString(String str) {
        return str.toUpperCase();
    }
}

class Employee {
    String name;
    int salary;
    int age;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}