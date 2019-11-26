package com.nirvana.learning.codingninjas.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfitableStocks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arr = bufferedReader.readLine().split("\\s+");
        int maxProfit = Integer.parseInt(arr[1])-Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);
        for(int i=0;i<arr.length;i++){
            int num = Integer.parseInt(arr[i]);
            if(num - min > maxProfit){
                maxProfit = num - min;
            }
            if(num<min){
                min = num;
            }
        }
        System.out.println(maxProfit);

    }
}
