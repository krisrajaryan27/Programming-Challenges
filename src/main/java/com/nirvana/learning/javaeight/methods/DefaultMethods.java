package com.nirvana.learning.javaeight.methods;

interface Vehicle {
    void cleanVehicle();

    default void startVehicle() {
        System.out.println("Vehicle is starting!");
    }
}

class Car implements Vehicle {

    @Override
    public void cleanVehicle() {
        System.out.println("Cleaning the vehicle");
    }
}

/**
 * Default Methods in Interfaces - Default methods are methods that can have a body
 * To provide additional functionality to a given type without breaking down the implementing classes.
 */
public class DefaultMethods {
    public static void main(String[] args) {
        Car car = new Car();
        car.cleanVehicle();
        car.startVehicle();
    }

}
