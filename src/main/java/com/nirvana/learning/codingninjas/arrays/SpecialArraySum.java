package com.nirvana.learning.codingninjas.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arr = bufferedReader.readLine().split("\\s+");
        int result = 0;
        for (int i = 0; i <arr.length; i++) {
            result += Integer.parseInt(arr[i]);
        }
        System.out.println(digSum(result));

    }
    public static int digSum(int n)
    {
        if (n == 0)
            return 0;
        return (n % 9 == 0) ? 9 : (n % 9);
    }
}
