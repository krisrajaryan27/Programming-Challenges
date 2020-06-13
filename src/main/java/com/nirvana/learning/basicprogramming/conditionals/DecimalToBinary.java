package com.nirvana.learning.basicprogramming.conditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecimalToBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int decimalNum = Integer.parseInt(bufferedReader.readLine().trim());
        int temp = 0;
        int index = 0;
        int[] binaryArr = new int[1000];
        while (decimalNum > 0) {
            temp = decimalNum % 2;
            binaryArr[index] = temp;

            decimalNum = decimalNum / 2;
            index++;
        }
        for (int j = index - 1; j >= 0; j--) {
            System.out.print(binaryArr[j]);
        }
    }
}
