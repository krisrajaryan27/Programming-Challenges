package com.nirvana.learning.interview.string;

public class ReverseString {
    public static String reverseString(String s) {
        char[] characters = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = characters[i];
            characters[i++] = characters[j];
            characters[j--] = temp;
        }
        return new String(characters);
    }

    public static String reverse(String str) {
        // code goes here
        int len = str.length();
        char[] result = new char[len];
        for (int index = 0; index < len; index++) {
            result[len - index - 1] = str.charAt(index);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String str = "Krishna";
        System.out.println(reverseString(str));
        System.out.println(reverse(str));
    }
}
