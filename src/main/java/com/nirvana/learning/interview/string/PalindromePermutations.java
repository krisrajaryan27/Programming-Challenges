package com.nirvana.learning.interview.string;

/**
 * Write a function to check if a string is permutation of a palindrome
 */
public class PalindromePermutations {
    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"};
        for (String s : strings) {
            boolean a = isPermutationOfPalindrome(s);
            boolean b = isPermutationOfPalindrome(s);
            boolean c = isPermutationOfPalindrome(s);
            System.out.println(s);
            if (a == b && b == c) {
                System.out.println("Agree: " + a);
            } else {
                System.out.println("Disagree: " + a + ", " + b + ", " + c);
            }
            System.out.println();
        }
    }

    private static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharacterFrequency(phrase);
        return checkMaxOneOdd(table);
    }

    private static int[] buildCharacterFrequency(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char ch : phrase.toCharArray()) {
            int x = getCharNumber(ch);
            if (x != -1) table[x]++;
        }
        return table;
    }

    private static int getCharNumber(Character ch) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(ch);
        if (a <= val && val <= z) return val - a;
        return -1;
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOneOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOneOdd) return false;
            }
            foundOneOdd = true;
        }
        return true;
    }

    private static boolean isPermutationOfPalindromeM2(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    //Create a bit vector for the string. For each letter with value i, toggle the ith bit
    private static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char ch : phrase.toCharArray()) {
            int x = getCharNumber(ch);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    //Toggle the ith bit in the integer
    private static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;
        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    //Check that exactly one bit is set by subtracting one from the integer and ANDing it with the original integer
    private static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

}
