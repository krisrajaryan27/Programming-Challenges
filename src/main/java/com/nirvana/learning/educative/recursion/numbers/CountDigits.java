package com.nirvana.learning.educative.recursion.numbers;

public class CountDigits {
    public static int countDigitsIterative(int num) {
        int count = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    public static int countDigitsRecursive(int num) {
        if (num / 10 == 0) {
            return 1;
        } else {
            return 1 + countDigitsRecursive(num / 10);
        }
    }

    public static void main(String[] args) {

        int input = 1435043;
        int numDigits = countDigitsIterative(input);
        System.out.println("Number of digits in iterative way in input: " + input + " = " + numDigits);

        input = 74333220;
        numDigits = countDigitsRecursive(input);
        System.out.println("Number of digits in recursive way in input: " + input + " = " + numDigits);
    }
}
