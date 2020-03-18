package com.nirvana.learning.educative.recursion.string;

public class RemoveDuplicates {


    private static String remDuplicates(String text) {
        //Base Case
        if (text.length() == 1) {
            return text;
        }
        //Recursive Case
        if (text.substring(0, 1).equalsIgnoreCase(text.substring(1, 2))) {
            return remDuplicates(text.substring(1));
        } else {
            return text.substring(0, 1) + remDuplicates(text.substring(1));
        }
    }

    public static void main(String[] args) {
        String input1 = "hHelloo";
        String input2 = "Thiss iiss aa teesstt";

        System.out.println("Original string: " + input1);

        String output = remDuplicates(input1);

        System.out.println("String after: " + output);


        System.out.println("Original string: " + input2);

        output = remDuplicates(input2);

        System.out.println("String after: " + output);
    }
}
