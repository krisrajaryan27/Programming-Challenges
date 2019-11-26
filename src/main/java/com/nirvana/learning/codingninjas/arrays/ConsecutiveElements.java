package com.nirvana.learning.codingninjas.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConsecutiveElements {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arr = bufferedReader.readLine().split("\\s+");
        Arrays.sort(arr);
        int start = Integer.parseInt(arr[0]);
        boolean flag = true;
        for (int i=0;i<arr.length;i++){
            if(Integer.parseInt(arr[i])!=(start+i)){
                 flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
