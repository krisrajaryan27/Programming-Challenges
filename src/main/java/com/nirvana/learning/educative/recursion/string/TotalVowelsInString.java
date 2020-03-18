package com.nirvana.learning.educative.recursion.string;

public class TotalVowelsInString {
    public static void main(String[] args) {
        String string1 = "Hello world";
        String string2 = "STR";
        String string3 = "AEIOUaeiouSs";

        int result1 = callTotalVowelsM1(string1);
        int result2 = callTotalVowelsM2(string2);
        int result3 = callTotalVowelsM2(string3);

        System.out.println("Total number of vowels in " + string1 + " are = " + result1);
        System.out.println("Total number of vowels in " + string2 + " are = " + result2);
        System.out.println("Total number of vowels in " + string3 + " are = " + result3);
    }

    public static int callTotalVowelsM1(String text) {
        return totalVowelsM1(text, text.length(), 0);
    }

    public static int callTotalVowelsM2(String text) {
        return totalVowelsM2(text, text.length(), 0);
    }

    //Faster Solution
    public static int totalVowelsM1(String text, int len, int index) {
        int count = 0;

        if (len == 0) {
            return 0;
        }
        char single = Character.toUpperCase(text.charAt(index));
        if (single == 'A' || single == 'E' || single == 'I' || single == 'O' || single == 'U') {
            count++;
        }
        return count + totalVowelsM1(text, len - 1, index + 1);
    }

    public static int totalVowelsM2(String text, int len, int index) {
        // Write your code here
        if (len == 0) {
            return 0;
        }
        String vowel = "AEIOUaeiou";
        if (vowel.contains(text.substring(index, index + 1))) {
            return 1 + totalVowelsM2(text.substring(1), len - 1, index);
        }
        return totalVowelsM2(text.substring(1), len - 1, index);
    }
}
