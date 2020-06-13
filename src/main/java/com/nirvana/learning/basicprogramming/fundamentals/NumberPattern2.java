package com.nirvana.learning.basicprogramming.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberPattern2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int i, j, k;
        for (i = 1; i <= n; i++) {
            k = i;
            for (j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= i; k++, j++) {

                System.out.print(k);
            }
            System.out.println();
        }
    }
}
