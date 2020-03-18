package com.nirvana.learning.educative.recursion.arrays;

public class PalindromeArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 1};
        System.out.println(isPalindrome(array, 0));
    }

    private static boolean isPalindrome(int[] array, int index) {
        if (index == array.length / 2) {
            return true;
        }
        if (array[index] != array[array.length - 1 - index]) {
            return false;
        }
        return isPalindrome(array, index + 1);
    }
}
