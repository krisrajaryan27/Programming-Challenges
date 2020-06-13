package com.nirvana.learning.javaeight.streamapi;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The Optional<T> is a wrapper class that stores an object of type T.
 * The object may or may not be present in the optional.
 */
public class OptionalImpl {
    Map<Integer, Worker> workerMap = new HashMap<>();

    public static String getDefaultValue() {
        return "default";
    }

    public static void main(String[] args) {
        OptionalImpl optionalImpl = new OptionalImpl();

        //Fetching the worker with id 123. But since map is empty this will be null.
        Optional<Worker> worker = optionalImpl.getWorker(123);
        if (worker.isPresent()) {
            System.out.println(worker.get().getName());
        } else {
            System.out.println("No Employee returned");
        }

        worker.ifPresent(System.out::println);

        Optional<String> optional = Optional.ofNullable(null);

        //This method returns the value present in the optional. If no value is present,
        // then a default value provided as a parameter is returned.
        System.out.println(optional.orElse("Default String"));

        //This method returns the value present in the optional. If no value is present,
        // then the value calculated from the supplier provided as a parameter is returned.
        System.out.println(optional.orElseGet(OptionalImpl::getDefaultValue));

        Optional<String> fruit = Optional.ofNullable("Orange");
        // Since the filter condition is matched, this will return the optional.
        System.out.println(fruit.filter(str -> str.equals("Orange")));

        // Since the filter condition is not matched, this will return empty optional.
        System.out.println(fruit.filter(str -> str.equals("Apple")));

        //This method returns the value present in the optional. If no value is present,
        // then it throws the exception created by the provided supplier.
        try {
            System.out.println(optional.orElseThrow(() -> new Exception("Resource not found.")));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // Before returning the employee object we are wrapping it into an Optional
    public Optional<Worker> getWorker(Integer workerId) {
        return Optional.ofNullable(workerMap.get(workerId));
    }
}

class Worker {
    String name;
    int workerId;
    int salary;

    public Worker(String name, int workerId, int salary) {
        this.name = name;
        this.workerId = workerId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
