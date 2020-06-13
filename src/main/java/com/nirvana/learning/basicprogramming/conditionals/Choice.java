package com.nirvana.learning.basicprogramming.conditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Choice {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number, N: ");
        String[] arr = {
                "1 : Print sum of 1 to N numbers",
                "2 : Print product of 1 to N numbers",
                "Any other number : print -1"
        };
        int N = Integer.parseInt(bufferedReader.readLine().trim());
        Arrays.stream(arr).forEach(System.out::println);
        int C = Integer.parseInt(bufferedReader.readLine().trim());
        int sum = 0;
        int prod = 1;
        if (C == 1) {
            for (int i = 1; i <= N; i++) {
                sum += i;
            }
            System.out.println(sum);
        } else if (C == 2) {
            for (int i = 1; i <= N; i++) {
                prod *= i;
            }
            System.out.println(prod);
        } else {
            System.out.println(-1);
        }

    }
}
