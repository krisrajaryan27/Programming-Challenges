package com.nirvana.learning.codingninjas.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimeNoBelow {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,true);
        for(int i=2;i<=n;i++){
            if(arr[i] == true){
                for(int j=i*i;j<=n;j+=i){
                    arr[j]=false;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(arr[i] == true) {
                System.out.print(i+" ");
            }
        }
    }
}
