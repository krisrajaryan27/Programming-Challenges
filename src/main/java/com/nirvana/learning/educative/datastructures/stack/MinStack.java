package com.nirvana.learning.educative.datastructures.stack;

/**
 * Create Stack where min() gives minimum in O(1)
 */
public class MinStack {

    int maxSize;
    Stack<Integer> mainStack;
    Stack<Integer> minStack;


    //constructor
    public MinStack(int maxSize) {
        //We will use two stacks mainStack to hold original values
        //and minStack to hold minimum values. Top of minStack will always
        //be the minimum value from mainStack
        this.maxSize = maxSize;
        mainStack = new Stack<>(maxSize);
        minStack = new Stack<>(maxSize);

    }

    //removes and returns value from stack
    public Integer pop() {
        //1. Pop element from minStack to make it sync with mainStack,
        //2. Pop element from mainStack and return that value
        minStack.pop();
        return mainStack.pop();
    }

    //pushes value into the stack
    public void push(Integer value) {
        //1. Push value in mainStack and check value with the top value of minStack
        //2. If value is greater than top, then push top in minStack
        //else push value in minStack
        mainStack.push(value);
        if (!minStack.isEmpty() && minStack.top() < value)
            minStack.push(minStack.top());
        else
            minStack.push(value);
    }

    //returns minimum value in O(1)
    public int min() {
        return minStack.top();
    }

}
