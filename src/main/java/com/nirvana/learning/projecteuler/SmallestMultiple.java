package com.nirvana.learning.projecteuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author KrishnaV
 */
public class SmallestMultiple {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        Set<Integer> primeSet = new HashSet<>();
        primeSet = findPrime(num);
        long product=0;
        System.out.println(leastCommonMultiple(num));

    }

    static long leastCommonMultiple(long n) {
        long multiple = 1;

        for ( long i = 2; i <= n; i++ ) {
            multiple *= i / gcd(i, multiple);
        }

        return multiple;
    }

    static long gcd(long a, long b) {
        return ( 0 == b ) ? a : gcd(b, a%b);
    }

    private static Set<Integer> findPrime(int num){
        Set<Integer> primeSet = new HashSet<>();
        for (int i=1;i<=num;i++){
            if(isPrime(i))
            primeSet.add(i);
        }
    return primeSet;
    }

    private static boolean isPrime(int num){
        if(num<1)
            return false;
        if(num<=3)
            return true;
        if(num%2 == 0 || num%3 ==0)
            return false;
        for(int i=5;i*i<=num;i=i+6){
            if(num%i==0 || num%(i+2) ==0)
                return false;
        }
        return true;
    }
}
