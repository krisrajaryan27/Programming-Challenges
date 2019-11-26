package com.nirvana.learning.codingninjas.conditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseNo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine().trim());
        int temp = 0;
        int reversedNum = 0;
        while(num>0){
            temp = num %10;
            reversedNum = 10 * reversedNum + temp;
            num = num /10 ;
        }
        System.out.println(reversedNum);
    }
}
