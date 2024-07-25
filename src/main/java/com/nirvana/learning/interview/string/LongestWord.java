package com.nirvana.learning.interview.string;

/***
 * Have the function LongestWord(sentence) take the sen parameter being passed
 * and return the longest word in the string. If there are two or more words that are the same length,
 * return the first word from the string with that length.
 * Ignore punctuation and assume sen will not be empty.
 * Words may also contain numbers, for example "Hello world123 567"
 * Examples
 * Input: "fun&!! time"
 * Output: time
 * Input: "I love dogs"
 * Output: love
 * **/
public class LongestWord {
    public static String longestWord(String sen) {
        // Remove punctuation using regex and split the string into words
        String[] words = sen.replaceAll("[^a-zA-Z0-9 ]", "").split(" ");
        String longestWord = "";

        // Iterate through the words to find the longest one
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word; // Update longestWord if a longer word is found
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(longestWord("fun&!! time"));         // Output: "time"
        System.out.println(longestWord("I love dogs"));         // Output: "love"
        System.out.println(longestWord("Hello world123 567"));  // Output: "world123"
        System.out.println(longestWord("A quick brown fox!"));   // Output: "quick"
    }
}
