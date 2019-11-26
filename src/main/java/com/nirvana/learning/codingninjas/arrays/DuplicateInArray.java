package com.nirvana.learning.codingninjas.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DuplicateInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arr = bufferedReader.readLine().split("\\s+");
        Map<String,Boolean> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],!map.get(arr[i]));
                System.out.println(arr[i]);
                break;
            }
           map.put(arr[i],true);
        }

    }
}
