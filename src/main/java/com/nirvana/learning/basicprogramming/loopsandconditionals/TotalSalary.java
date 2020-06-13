package com.nirvana.learning.basicprogramming.loopsandconditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TotalSalary {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");
        int basicSalary = Integer.parseInt(input[0]);
        String grade = input[1];
        double hra = 0.2 * basicSalary;
        double da = 0.5 * basicSalary;
        double allow;
        if (grade.equalsIgnoreCase("A")) {
            allow = 1700;
        } else if (grade.equalsIgnoreCase("B")) {
            allow = 1500;
        } else {
            allow = 1300;
        }
        double pf = 0.11 * basicSalary;
        double totalSalary = Math.round(basicSalary + hra + da + allow - pf);
        System.out.println((int) totalSalary);
    }
}
