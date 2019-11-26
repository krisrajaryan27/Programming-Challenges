package com.nirvana.learning.codingninjas.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String str = bufferedReader.readLine().trim();
        System.out.println(checkIfPanagram(n, str));
    }

    private static boolean checkIfPanagram(int n, String str) {
        if(n<26){
            return false;
        }
        boolean[] mark = new boolean[26];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                index = str.charAt(i) - 'A';
            else if('a' <= str.charAt(i) && str.charAt(i) <= 'z')
                index = str.charAt(i) - 'a';
            mark[index] = true;
        }

        for (int i = 0; i <= 25; i++)
            if (!mark[i])
                return (false);

        return (true);

    }

}
