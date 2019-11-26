package com.nirvana.learning.codingninjas.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AverageMarks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine().trim();
        String[] marks = bufferedReader.readLine().split("\\s+");
        int total = 0;
        for (int i=0;i<marks.length;i++){
            total += Integer.parseInt(marks[i]);
        }
        int avgMarks = total/marks.length;
        System.out.println(name);
        System.out.println(avgMarks);

    }
}
