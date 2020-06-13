package com.nirvana.learning.basicprogramming.loopsandconditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerOfNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");
        int x = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        System.out.println(result);
    }
}
