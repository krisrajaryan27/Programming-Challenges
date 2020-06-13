package com.nirvana.learning.interview.string;

import java.util.*;

/**
 * Given a list of words, produce an algorithm that will return a list of all anagrams for a specific word.
 */
public class AnagramList {
    static final Map<String, List<String>> lookup = new HashMap<>();

    public static void main(String[] args) {
        List<String> words = Arrays.asList("abc", "bac", "cab", "cba");
        findAnagrams(words);
        System.out.println(getAnagrams("abc"));
    }

    public static void findAnagrams(final List<String> words) {
        for (final String word : words) {
            final String signature = alphabetize(word);
            if (lookup.containsKey(signature)) {
                lookup.get(signature).add(word);
            } else {
                final List<String> anagramList = new ArrayList<>();
                anagramList.add(word);
                lookup.put(signature, anagramList);
            }
        }
    }

    private static String alphabetize(final String word) {
        final byte[] bytes = word.getBytes();
        Arrays.sort(bytes);
        return new String(bytes);
    }

    public static List<String> getAnagrams(final String word) {
        final String signature = alphabetize(word);
        final List<String> anagrams = lookup.get(signature);
        return anagrams == null ? new ArrayList<String>() : anagrams;
    }
}

