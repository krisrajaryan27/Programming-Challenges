package com.nirvana.learning.interview.bits;


public class AddTwoNumberInBinaryRepresentation {

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int maxLength = Math.max(lenA, lenB);
        char[] result = new char[maxLength + 1]; // +1 for possible carry
        int i = lenA - 1;
        int j = lenB - 1;
        int carry = 0;
        int index = maxLength;

        // Loop until both strings are processed and no carry remains
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry; // Start with the carry

            // Add the last digit of a if available
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to int
                i--;
            }

            // Add the last digit of b if available
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to int
                j--;
            }

            // Store the result (sum mod 2) in the result array
            result[index] = (char) ((sum % 2) + '0'); // Convert int back to char
            carry = sum / 2; // Calculate carry for next iteration
            index--;
        }

        // Convert the result array to a string, skipping leading zeros
        return new String(result, index + 1, maxLength - index);
    }



}
