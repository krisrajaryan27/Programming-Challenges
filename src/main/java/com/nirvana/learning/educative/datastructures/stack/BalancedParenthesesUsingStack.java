package com.nirvana.learning.educative.datastructures.stack;

public class BalancedParenthesesUsingStack {
    public static void main(String[] args) {
        String expression = "{}{}{}";
        System.out.println(isBalancedOptimised(expression));

    }

    /* Return true if expression has balanced Parenthesis */
    public static boolean isBalanced(String expression) {
        /* Declare an empty character stack */
        int length = expression.length();
        Stack<Character> stack = new Stack<>(length);

       /* Traverse the given expression to
          check matching parenthesis */
        for (int i = 0; i < length; i++) {

          /*If the exp[i] is a starting
            parenthesis then push it*/
            char ch = expression.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[')
                stack.push(ch);

          /* If exp[i] is an ending parenthesis
             then pop from stack and check if the
             popped parenthesis is a matching pair*/
            if (ch == '}' || ch == ')' || ch == ']') {

              /* If we see an ending parenthesis without
                 a pair then return false*/
                if (stack.isEmpty()) {
                    return false;
                }

             /* Pop the top element from stack, if
                it is not a pair parenthesis of character
                then there is a mismatch. This happens for
                expressions like {(}) */
                else return isMatchingPair(stack.pop(), ch);
            }
        }

       /* If there is something left in expression
          then there is a starting parenthesis without
          a closing parenthesis */

        /*not balanced*/
        return stack.isEmpty(); /*balanced*/
    }

    /* Returns true if character1 and character2
       are matching left and right Parenthesis */
    static boolean isMatchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else return character1 == '[' && character2 == ']';
    }

    public static boolean isBalancedOptimised(String exp) {

        //Iterate through the string exp.
        //For each opening parentheses, push it into stack
        //For every closing parentheses check for its opening parentheses in stack
        //If you can't find the opening parentheses for any closing one then returns false.
        //and after complete traversal of string exp, if there's any opening parentheses left
        //in stack then also return false.
        //At the end return true if you haven't encountered any of the above false conditions.
        Stack<Character> stack = new Stack<>(exp.length());

        for (int i = 0; i < exp.length(); i++) {

            char character = exp.charAt(i);

            if (character == '}' || character == ')' || character == ']') {

                if (stack.isEmpty()) return false;

                if ((character == '}' && stack.pop() != '{') || (character == ')' && stack.pop() != '(') || (character == ']' && stack.pop() != '['))
                    return false;

            } else stack.push(character);

        } //end of for
        return stack.isEmpty();
    }
}
