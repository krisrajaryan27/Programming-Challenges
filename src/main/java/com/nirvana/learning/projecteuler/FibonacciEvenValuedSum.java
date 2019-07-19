package com.nirvana.learning.projecteuler;

/**
 * @author KrishnaV
 */
public class FibonacciEvenValuedSum {

    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 1;
        int temp = 0;
        int sum = 0;
        do {
            if(num2%2==0){
                sum+=num2;
            }
            temp = num1+num2;
            num1= num2;
            num2= temp;
        } while(num2<4000000);
        System.out.println(sum);
    }

}
