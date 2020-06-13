package com.nirvana.learning.basicprogramming.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindCharacterCase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine().trim();
        String upperCaseName = name.toUpperCase();
        String lowerCase = name.toLowerCase();
        int ascii = name.charAt(0);
        if ((ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123)) {
            if (name.equals(upperCaseName)) {
                System.out.println(1);
            } else if (name.equals(lowerCase)) {
                System.out.println(0);
            }
        } else {
            System.out.println(-1);
        }
    }
}
