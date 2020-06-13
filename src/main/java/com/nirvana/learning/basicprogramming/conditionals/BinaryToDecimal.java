package com.nirvana.learning.basicprogramming.conditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryToDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int binaryNum = Integer.parseInt(bufferedReader.readLine().trim());
        int decimalNum = 0;
        int temp = 0;
        int count = -1;
        while (binaryNum > 0) {
            ++count;
            temp = binaryNum % 10;
            int mult = (int) Math.pow(2, count);
            decimalNum = decimalNum + temp * mult;
            binaryNum /= 10;
        }
        System.out.println(decimalNum);
    }
}
