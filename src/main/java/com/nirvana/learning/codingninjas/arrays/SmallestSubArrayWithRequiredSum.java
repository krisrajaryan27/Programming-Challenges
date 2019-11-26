package com.nirvana.learning.codingninjas.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmallestSubArrayWithRequiredSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] arr = bufferedReader.readLine().split("\\s+");
        int x = Integer.parseInt(bufferedReader.readLine().trim());
        int min_len = arr.length+1;
        List<Integer> arrList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int curr_sum = Integer.parseInt(arr[i]);
            if(curr_sum>x){
                System.out.println(1);
                break;
            }
            for(int j= i+1;j<arr.length;j++){
                curr_sum+=Integer.parseInt(arr[j]);
                if(curr_sum>x && (j-i+1)<min_len){
                    min_len= j-i+1;
                    arrList.add(Integer.parseInt(arr[i]));
                    arrList.add(Integer.parseInt(arr[j]));

                }
            }
        }
        System.out.println(min_len);
        Iterator iterator= arrList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
}
