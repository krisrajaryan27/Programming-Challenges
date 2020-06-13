package com.nirvana.learning.interview.string;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    private static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine().trim();
        num = Integer.parseInt(str);
        System.out.println(fizzBuzz(num));
        System.out.println(alternativeFizzBuzz(num));

    }

    public static List<String> fizzBuzz(final int n) {
        final List<String> toReturn = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                toReturn.add("FizzBuzz");
            } else if (i % 3 == 0) {
                toReturn.add("Fizz");
            } else if (i % 5 == 0) {
                toReturn.add("Buzz");
            } else {
                toReturn.add(Integer.toString(i));
            }
        }
        return toReturn;
    }

    public static List<String> alternativeFizzBuzz(final int n) {
        final List<String> toReturn = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            final String word =
                    toWord(3, i, "Fizz") + toWord(5, i, "Buzz");
            if (StringUtils.isEmpty(word)) {
                toReturn.add(Integer.toString(i));
            } else {
                toReturn.add(word);
            }
        }
        return toReturn;
    }

    private static String toWord(final int divisor, final int value,
                                 final String word) {
        return value % divisor == 0 ? word : "";
    }
}
