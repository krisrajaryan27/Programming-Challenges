package com.nirvana.learning.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DivisorGame {

    static Map<Integer, Boolean> map = new HashMap<>();
    public static boolean divisorGame(int N) {
        if (map.containsKey(N)){
            return map.get(N);
        }
        for (int i = 1; i < N; i++){
            if (N % i == 0){
                if (!divisorGame(N-i)){
                    return true;
                }
            }
        }
        map.put(N, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(4));
    }
}
