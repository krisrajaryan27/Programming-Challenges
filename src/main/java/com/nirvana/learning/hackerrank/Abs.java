package com.nirvana.learning.hackerrank;

abstract class Base {
    abstract public void myFunc();

    public void another() {
        System.out.println("Another Method");
    }
}

public class Abs extends Base1 {
    public static void main(String[] args) {
        Abs a = new Abs();
        a.aMethod();
    }

    public void myFunc() {
        System.out.println("My Func");
    }

    public void aMethod() {
        myFunc();
    }
}
