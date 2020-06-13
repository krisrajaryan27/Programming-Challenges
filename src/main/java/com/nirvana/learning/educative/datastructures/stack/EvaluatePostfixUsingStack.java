package com.nirvana.learning.educative.datastructures.stack;

public class EvaluatePostfixUsingStack {

    public static void main(String[] args) {
        String expression = "921*-8-4+";
        System.out.println(evaluatePostFix(expression));
    }

    public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>(expression.length());
        //1.Scan expression character by character,
        //2.If character is a number push it in stack
        //3.If character is operator then pop two elements from stack
        //perform the operation and put the result back in stack
        //At the end, Stack will contain result of whole expression.
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            }
            // If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else {
                int value1 = stack.pop();
                int value2 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(value2 + value1);
                        break;
                    case '-':
                        stack.push(value2 - value1);
                        break;
                    case '/':
                        stack.push(value2 / value1);
                        break;
                    case '*':
                        stack.push(value2 * value1);
                        break;
                }
            }
        }
        return stack.pop();
    }

}
