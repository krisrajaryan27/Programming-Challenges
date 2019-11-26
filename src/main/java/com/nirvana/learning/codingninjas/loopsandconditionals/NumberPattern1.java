package com.nirvana.learning.codingninjas.loopsandconditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberPattern1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(1 +" ");
            }
            System.out.println("");
        }

    }
}
