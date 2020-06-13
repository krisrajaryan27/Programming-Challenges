package com.nirvana.learning.educative.recursion.string;

public class StringPalindrome {

    public static Object isPalindromeIteratively(String text) {
        // Write your code here
        if (text.isEmpty()) {
            return false;
        }
        int length = text.length();
        int midPoint = text.length() / 2;
        String lastHalf = new StringBuilder(text.substring(midPoint + 1, length)).reverse().toString();
        return text.substring(0, midPoint).equalsIgnoreCase(lastHalf);
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() == 0) {
            return false;
        } else if (text.length() == 1) {
            return true;
        } else {
            if (text.charAt(0) == text.charAt(text.length() - 1)) {
                return isPalindromeRecursive(text.substring(1, text.length() - 1));
            }
        }
        return false;
    }

    public static boolean isPalindromeMethod3(String text) {
        if (text.isEmpty()) {
            return false;
        }
        String reverse = reverseString(text);
        return text.equalsIgnoreCase(reverse);
    }

    private static String reverseString(String text) {
        char[] chars = text.toCharArray();
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeIteratively("Madam"));
        System.out.println(isPalindromeIteratively("dad"));
        System.out.println(isPalindromeRecursive("Hello"));
        System.out.println(isPalindromeIteratively("Malayalam"));
        System.out.println(isPalindromeMethod3("Malayalam"));
    }
}
