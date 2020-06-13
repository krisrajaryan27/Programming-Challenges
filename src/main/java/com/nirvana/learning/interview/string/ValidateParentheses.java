package com.nirvana.learning.interview.string;

import java.util.*;

public class ValidateParentheses {
    public static void main(String[] args) {
        String str1 = "()(){(())";
        String str2 = "";
        String str3 = "([{}])()";

        boolean status1 = validateParentheses(str1);
        boolean status2 = validateParentheses(str1);
        boolean status3 = validateParentheses(str1);
        System.out.println(status1 + " " + status2 + " " + status3);
    }

    private static boolean validateParentheses(String str) {
        List<Character> closingParentheses = new ArrayList<>();
        closingParentheses.add(')');
        closingParentheses.add('}');
        closingParentheses.add(']');
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put(')', '(');
        characterMap.put('}', '{');
        characterMap.put(']', '[');
        Stack<Character> stack = new Stack<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!closingParentheses.contains(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else if (!stack.isEmpty() && characterMap.get(str.charAt(i)).equals(stack.peek())) {
                stack.pop();
            } else if (stack.isEmpty()) {
                return false;
            }
        }
        return stack.isEmpty();

    }
}
