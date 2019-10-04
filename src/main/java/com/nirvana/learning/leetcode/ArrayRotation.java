package com.nirvana.learning.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author KrishnaV
 */
public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        leftRotateArray(arr,d);
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println("");
        rightRotateArray(arr,d);
        for (int i: arr){
            System.out.print(i+" ");
        }
    }

    private static void optimisedLeftRotateArray(int[] arr, int d) {
        int i,j,k,temp;
        int n = arr.length;
        int hcf = gcd(d,n);
        for(i=0;i<hcf;i++){
            temp = arr[i];
            j=i;
            while (true){
                k = j+d;
                if(k>=n)
                    k = k-n;
                if(k==i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    private static int gcd(int a, int b) {
        if(b==0){
            return a;
        } else return gcd(b,a%b);

    }

    private static void leftRotateArray(int[] arr, int d) {
        for(int i=0;i<d;i++){
            leftRotateArrayByOne(arr);
        }
    }
    private static void rightRotateArray(int[] arr,int d){
        for (int i=0;i<d;i++){
            rightRotateArrayByOne(arr);
        }
    }

    private static void rightRotateArrayByOne(int[] arr) {
        int temp = arr[arr.length-1], i;
        for(i=arr.length-1;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[i] = temp;
    }

    private static void leftRotateArrayByOne(int[] arr) {
        int temp = arr[0];
        int i;
        for(i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
    }
}