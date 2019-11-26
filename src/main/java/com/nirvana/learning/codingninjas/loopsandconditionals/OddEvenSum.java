package com.nirvana.learning.codingninjas.loopsandconditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine().trim());
        int temp = 0;
        int evenSum = 0;
        int oddSum = 0;
        while(num>0){
            temp = num%10;
            if(temp%2==0){
                evenSum+=temp;
            } else{
                oddSum += temp;
            }
            num = num/10;
        }
        System.out.println(evenSum+" "+oddSum);
    }
}
