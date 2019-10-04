package com.nirvana.learning.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


 class Result {

    /*
     * Complete the 'plusMult' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY A as parameter.
     */

    public static String plusMult(List<Integer> A) {
        long sumOdd = 0;
        long sumEven = 0;
       for(Integer i: A){
           int index = A.indexOf(i);
           if(index %4 ==0){
               sumEven += i;
           }
           if(index%4!=0 &&index%2 ==0){
               sumEven *= i;
           }
           if((index-1)%4==0){
               sumOdd += i;
           }
           if((index-1)%4!=0 && (index-1)%2==0){
               sumOdd *= i;
           }
       }
       long rOdd = sumOdd %2;
       long rEven = sumEven %2;
       if(rOdd>rEven){
           return "ODD";
       } else if(rOdd<rEven){
           return "EVEN";
       } else{
           return "NEUTRAL";
       }


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int ACount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> A = new ArrayList<>();

        for (int i = 0; i < ACount; i++) {
            int AItem = Integer.parseInt(bufferedReader.readLine().trim());
            A.add(AItem);
        }

        String result = Result.plusMult(A);
        System.out.println(result);



        bufferedReader.close();
    }
}
