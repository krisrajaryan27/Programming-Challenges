package com.nirvana.learning.educative.recursion.numbers;

public class SumOfIntegers {

    public static int sumOfIntegers(int num) {
        if (num == 1) {
            return num;
        }
        return num + sumOfIntegers(num - 1);
    }


    public static void main(String[] args) {
        int input = 5;
        int sum = sumOfIntegers(input);
        System.out.println("The sum of integers from 1 to " + input + " is: " + sum);
    }
}
