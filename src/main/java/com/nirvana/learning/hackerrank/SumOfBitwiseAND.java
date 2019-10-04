package com.nirvana.learning.hackerrank;

/**
 * @author KrishnaV
 */
public class SumOfBitwiseAND {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int sum = sumOfAnd(arr);
        System.out.println(sum);
    }

    private static int sumOfAnd(int[] arr) {
        int sum =0;
        for(int i=0;i<arr.length;i++){
            int andSum = arr[i];
            for(int j=i;j<arr.length;j++){
                andSum = andSum & arr[j];
                sum = sum+andSum;
            }
        }
        return sum;
    }


}
