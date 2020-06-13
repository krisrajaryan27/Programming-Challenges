package com.nirvana.learning.educative.datastructures.stack;

public class SortStackValues {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(2);
        stack.push(7);
        stack.push(9);
        stack.push(8);
        stack.push(1);
        stack.push(6);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        stack.push(10);
        sortStackIterative(stack);
    }

    public static void sortStackIterative(Stack<Integer> stack) {
        //1. Use a second tempStack.
        //2. Pop value from mainStack.
        //3. If the value is greater or equal to the top of tempStack, then push the value in tempStack
        //else pop all values from tempStack and push them in mainStack and in the end push value in tempStack and repeat from step 2.
        //till mainStack is not empty.
        //4. When mainStack will be empty, tempStack will have sorted values in descending order.
        //5. Now transfer values from tempStack to mainStack to make values sorted in ascending order.
        Stack<Integer> tempStack = new Stack<>(stack.getMaxSize());
        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            if (!tempStack.isEmpty() && value >= tempStack.top()) {
                tempStack.push(value);
            } else {
                while (!tempStack.isEmpty() && tempStack.top() > value)
                    stack.push(tempStack.pop());
                tempStack.push(value);
            }

        }
        while (!tempStack.isEmpty())
            stack.push(tempStack.pop());

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void insert(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || value < stack.top())
            stack.push(value);
        else {
            int temp = stack.pop();
            insert(stack, value);
            stack.push(temp);
        }
    }

    public static Stack<Integer> sortStackRecursive(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int value = stack.pop();
            sortStackRecursive(stack);
            insert(stack, value);
        }
        return stack;
    }
}
