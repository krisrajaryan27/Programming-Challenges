package com.nirvana.learning.javaeight.methods;

/**
 * Static Methods in Interfaces - The static methods in interfaces are similar to default methods,
 * But the only difference is that you can’t override them.
 */
interface Motor {
    static void cleanMotor() {
        System.out.println("I am cleaning the motor");
    }
}

class Bike implements Motor {
    public void print() {
        System.out.println("Printing inside the Bike");
    }
}

public class StaticMethod {
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.print();
        Motor.cleanMotor();
    }
}
