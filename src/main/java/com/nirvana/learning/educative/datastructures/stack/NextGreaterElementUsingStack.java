package com.nirvana.learning.educative.datastructures.stack;


import java.util.Arrays;

public class NextGreaterElementUsingStack {
    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 2, 8, 1};
        System.out.println(Arrays.toString(nextGreaterElementM1(arr)));
        System.out.println(Arrays.toString(nextGreaterElementOptimised(arr)));

    }

    public static int[] nextGreaterElementM1(int[] arr) {
        int length = arr.length;
        Stack<Integer> stack = new Stack<>(length);
        int[] result = new int[length];
        int j;
        for (int i = 0; i < length; i++) {
            for (j = i + 1; j < length; j++) {
                if (arr[j] > arr[i]) {
                    stack.push(arr[j]);
                    break;
                }
            }
            if (j == length) {
                stack.push(-1);
            }
        }
        int count = length - 1;
        while (!stack.isEmpty()) {
            result[count--] = stack.pop();
        }
        return result;
    }

    public static int[] nextGreaterElementOptimised(int[] arr) {
        int[] result = new int[arr.length];
        int resultIndex = 0;
        Stack<Integer> stack = new Stack<>(arr.length);
        // iterate for rest of the elements
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.top() <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else
                result[i] = stack.top();
            stack.push(arr[i]);
        }
        return result;
    }
}
