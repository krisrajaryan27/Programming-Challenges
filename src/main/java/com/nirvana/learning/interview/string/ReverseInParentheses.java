package com.nirvana.learning.interview.string;

/**
 * Write a function that reverses characters in (possibly nested) parentheses in the input string.
 * Input strings will always be well-formed with matching ()s.
 * Example
 * For inputString = "(bar)", the output should be
 * reverseInParentheses(inputString) = "rab";
 * For inputString = "foo(bar)baz", the output should be
 * reverseInParentheses(inputString) = "foorabbaz";
 * For inputString = "foo(bar)baz(blim)", the output should be
 * reverseInParentheses(inputString) = "foorabbazmilb";
 * For inputString = "foo(bar(baz))blim", the output should be
 * reverseInParentheses(inputString) = "foobazrabblim".
 * Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
 */
public class ReverseInParentheses {
    public static void main(String[] args) {
        System.out.println(reverseInParentheses("(bar)"));
        System.out.println(reverseInParenthesesOptimised("(bar)"));
    }

    private static String reverseInParentheses(String inputString) {
        if (inputString.length() == 0) return "";
        int begin = 0;
        int end;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '(') begin = i;
            if (inputString.charAt(i) == ')') {
                end = i;
                StringBuilder sb = new StringBuilder(inputString.substring(begin + 1, end));
                return reverseInParentheses(inputString.substring(0, begin) + sb.reverse().toString() + inputString.substring(end + 1));
            }
        }
        return inputString;
    }

    private static String reverseInParenthesesOptimised(String inputString) {
        StringBuilder str = new StringBuilder(inputString);
        int start, end;
        while (str.indexOf("(") != -1) {
            start = str.lastIndexOf("(");
            end = str.indexOf(")", start);
            str.replace(start, end + 1, new StringBuilder(str.substring(start + 1, end)).reverse().toString());
        }
        return str.toString();
    }
}
