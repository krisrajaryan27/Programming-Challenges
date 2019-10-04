package com.nirvana.learning.leetcode;

/**
 * @author KrishnaV
 */
public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }
    public static int fib(int N) {
        int[] f = new int[N+1];
        f[0] = 0;
        f[1] = 1;
        if(N<0){
            return -1;
        }
        for(int i=2;i<=N;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f[N];
    }
}
