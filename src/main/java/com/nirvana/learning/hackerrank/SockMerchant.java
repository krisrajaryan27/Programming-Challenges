package com.nirvana.learning.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {

    public static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int count =0;
        for(int i: ar){
            Integer j = mp.get(i);
            mp.put(i,(j==null) ? 1:j+1);
        }
        for(Map.Entry<Integer,Integer> val: mp.entrySet()){
            if(val.getValue()%2>=0 && val.getValue()/2>0){
               count += val.getValue()/2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {10,20,20,10,10,30,50,10,20};
        System.out.println(sockMerchant(7, arr));
    }

}
