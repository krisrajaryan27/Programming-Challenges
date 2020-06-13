package com.nirvana.learning.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultipleOfTwoAndThree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arr = bufferedReader.readLine().split("\\s+");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            if (num % 2 == 0 || num % 3 == 0) {
                sum += num;
            }
        }
        System.out.print(sum);
    }
}
