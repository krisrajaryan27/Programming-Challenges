package com.nirvana.learning.leetcode;

public class ReverseString {
    public static String reverseString(String s){
        char[] characters = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char temp = characters[i];
            characters[i++]=characters[j];
            characters[j--]=temp;
        }
        return new String(characters);
    }

    public static void main(String[] args) {
        String str = "Krishna";
        System.out.println(reverseString(str));
    }
}
