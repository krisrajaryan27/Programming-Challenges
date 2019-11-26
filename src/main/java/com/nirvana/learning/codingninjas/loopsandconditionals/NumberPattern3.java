package com.nirvana.learning.codingninjas.loopsandconditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberPattern3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                if(i==0){
                    System.out.print(1);
                }else if(j==0 || j==i){
                    System.out.print(1);
                }else {
                    System.out.print(2);
                }
            }
            System.out.println();
        }

    }
}
