package com.nirvana.learning.basicprogramming;

/***
 * Given a non-empty string like "Code" return a string like "CCoCodCode".
 * stringSplosion("Code") → "CCoCodCode"
 * stringSplosion("abc") → "aababc"
 * stringSplosion("ab") → "aab"
 * **/
public class StringSplosion {

    public static String stringSplosion(String str) {
        StringBuilder result = new StringBuilder();

        // Iterate through the string and build the result
        for (int i = 0; i < str.length(); i++) {
            // Append the substring from the start to the current index (inclusive)
            result.append(str, 0, i + 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(stringSplosion("Code")); // Output: "CCoCodCode"
        System.out.println(stringSplosion("abc"));  // Output: "aababc"
        System.out.println(stringSplosion("ab"));   // Output: "aab"
    }
}

