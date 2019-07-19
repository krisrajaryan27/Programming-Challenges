package com.nirvana.learning.projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author KrishnaV
 */
public class LargestPalindromeProduct {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        System.out.println(largestPalindromeProduct(num));

    }

    private static long largestPalindromeProduct(int num) {
        int upperLimit = 0;
        for(int i=1;i<=num;i++){
            upperLimit*=10;
            upperLimit+=9;
        }
        int lowerLimit = 1 + upperLimit/10;
        long maxProduct = 0;
        for(int i= upperLimit; i>=lowerLimit;i--){
            for(int j=i;j>=lowerLimit;j--){
                long product = i*j;
                if(product<maxProduct)
                    break;
                long number = product;
                if(isPalindrome(product) && product > maxProduct){
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    private static long getReverse(long number) {
        long reverse = 0;
        while(number!=0){
            reverse= reverse*10+ number%10;
            number/=10;
        }
        return reverse;
    }

    private static boolean isPalindrome(long number){
        return number==getReverse(number);
    }


}
