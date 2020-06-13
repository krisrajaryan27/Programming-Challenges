package com.nirvana.learning.basicprogramming.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FahrenhietToCelsius {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int startF = Integer.parseInt(bufferedReader.readLine().trim());
        int endF = Integer.parseInt(bufferedReader.readLine().trim());
        int gapF = Integer.parseInt(bufferedReader.readLine().trim());
        Map<Integer, Integer> fahrenCelsiusMap = new LinkedHashMap<>();
        for (int i = startF; i <= endF; i += gapF) {
            int celsius = (5 * (i - 32)) / 9;
            fahrenCelsiusMap.put(i, celsius);
        }
        for (Map.Entry<Integer, Integer> entry : fahrenCelsiusMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
