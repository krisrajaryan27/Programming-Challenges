package com.nirvana.learning.codingninjas.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Alternatives {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arr = bufferedReader.readLine().split("\\s+");
        int[] output = new int[arr.length];
        int pos = 0;
        int neg = 1;
        for (String value: arr) {
            int val = Integer.parseInt(value);
            if (val >= 0) {   // treat zero as positive
                output[pos] = val;
                pos += 2;
            } else {
                output[neg] = val;
                neg += 2;
            }
        }
        if (output.length >= 1) {
            System.out.print(output[0]);
        }

        for (int i = 1; i < output.length;i++) {
            System.out.print(" " + output[i]);
        }

    }
}
