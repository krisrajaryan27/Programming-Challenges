package com.nirvana.learning.interview.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AmazingStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine().trim();
        String str2 = bufferedReader.readLine().trim();
        String str3 = bufferedReader.readLine().trim();
        String str4 = str1.concat(str2);
        boolean status = true;
        if (str4.length() != str3.length()) {
            status = false;
        } else {
            Map<Character, Integer> stringMap = new HashMap<>();
            Map<Character, Integer> concatenatedStringMap = new HashMap<>();
            for (int i = 0; i < str3.length(); i++) {
                Character ch = str3.charAt(i);
                if (stringMap.containsKey(ch)) {
                    stringMap.put(ch, stringMap.get(ch) + 1);
                } else {
                    stringMap.put(ch, 1);
                }
            }
            for (int i = 0; i < str4.length(); i++) {
                Character ch = str4.charAt(i);
                if (concatenatedStringMap.containsKey(ch)) {
                    concatenatedStringMap.put(ch, concatenatedStringMap.get(ch) + 1);
                } else {
                    concatenatedStringMap.put(ch, 1);
                }
            }
            for (int i = 0; i < str3.length(); i++) {
                Character ch = str3.charAt(i);
                if (concatenatedStringMap.get(ch) != stringMap.get(ch)) {
                    status = false;
                    break;
                }
            }
        }
        if (status) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
