package com.nirvana.learning.basicprogramming.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarPattern {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int i, j, k;
        for (i = 1; i <= n; i++) {
            for (j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
