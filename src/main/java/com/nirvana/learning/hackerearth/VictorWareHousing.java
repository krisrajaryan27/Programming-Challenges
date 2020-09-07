package com.nirvana.learning.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class VictorWareHousing {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();
        String[] storage = bufferedReader.readLine().trim().split(",");
        String[] configurations = new String[storage.length - 1];
        for (int i = 0; i < storage.length - 1; i++) {
            configurations[i] = bufferedReader.readLine().trim();
        }
        for (int i = 0; i < storage.length - 1; i++) {
            String[] configValues = configurations[i].split("=");
            map.put(configValues[0], configValues[1]);
        }



    }
}
