package com.nirvana.learning.educative.recursion.string;

public class MergeStringsInAlphabeticalOrder {

    private static String mergeStringInAlphabeticalOrder(String one, String two) {
        if (one.isEmpty()) {
            return two.isEmpty() ? one : two;
        } else if (two.isEmpty()) {
            return one;
        } else if (two.charAt(0) > one.charAt(0)) {
            return one.charAt(0) + mergeStringInAlphabeticalOrder(one.substring(1), two);
        }
        return two.charAt(0) + mergeStringInAlphabeticalOrder(one, two.substring(1));

    }

    public static void main(String[] args) {
        String one = "cnt";
        String two = "ace";
        System.out.println(mergeStringInAlphabeticalOrder(one, two));
    }


}
