package com.nirvana.learning.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DivisionByFour {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arr = bufferedReader.readLine().split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            num = num / 4;
            if (num == 0) {
                arr[i] = String.valueOf(-1);
            }
            arr[i] = String.valueOf(num);
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
