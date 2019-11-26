package com.nirvana.learning.codingninjas.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine().trim();
        System.out.println(removeDuplicates(str));

    }

    private static String removeDuplicates(String str) {
        int len = str.length();
        if(len<2){
            return str;
        }
        int j=0;
        char[] strCh = str.toCharArray();
        for(int i=1;i<len;i++){
            if(strCh[j]!=strCh[i]){
                j++;
                strCh[j] = strCh[i];
            }
        }
        return String.copyValueOf(Arrays.copyOfRange(strCh,0,j+1));
    }
}
