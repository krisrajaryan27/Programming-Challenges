package com.nirvana.learning.interview.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DuplicateInArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bufferedReader.readLine().split("\\s+");
        Map<String, Boolean> map = new HashMap<>();
        for (String num : arr) {
            if (map.containsKey(num)) {
                map.put(num, !map.get(num));
                System.out.println(num);
                break;
            }
            map.put(num, true);
        }

    }
}
