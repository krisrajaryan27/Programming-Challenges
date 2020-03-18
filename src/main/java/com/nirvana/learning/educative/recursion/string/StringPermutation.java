package com.nirvana.learning.educative.recursion.string;

/**
 * find out all the permutations of size 4 for the below array [a, b, c, d]
 */
public class StringPermutation {
    public static void main(String[] args) {
        char[] array = new char[]{'a', 'b', 'c', 'd'};
        char[] perm = new char[array.length];
        boolean[] used = new boolean[256];
        // permute(array, perm, 0, used);

        permutateOptimized(array, 0);
    }

    /**
     * Note that we are using a boolean array to remember what
     * character we have already used and another array perm
     * which contains the actual permutation. We can actually
     * generate permutations without these additional arrays but
     * for now the desire is to make the code easier to understand.
     */
    static void permute(char[] array, char[] perm, int i, boolean[] used) {

        // base case
        if (i == perm.length) {
            System.out.println(perm);
            return;
        }

        for (char c : array) {

            if (!used[c - 'a']) {
                perm[i] = c;
                used[c - 'a'] = true;
                permute(array, perm, i + 1, used);
                used[c - 'a'] = false;
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    static void permutateOptimized(char[] str, int index) {

        // base case
        if (index == str.length) {
            System.out.println(str);
            return;
        }

        // regular case
        for (int i = index; i < str.length; i++) {
            swap(str, index, i);
            permutateOptimized(str, index + 1);
            swap(str, index, i);
        }
    }

    public static void permutations(char[] array, int length) {
        if (length == 1) {
            System.out.println(array);
            return;
        } else {
            for (int i = 0; i < length; i++) {
                swap(array, i, length - 1);
                permutations(array, length - 1);
                swap(array, i, length - 1);
            }
        }
    }
}
