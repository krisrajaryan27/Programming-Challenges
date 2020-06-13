package com.nirvana.learning.basicprogramming.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberPattern {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= (2 * i - 1); j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
