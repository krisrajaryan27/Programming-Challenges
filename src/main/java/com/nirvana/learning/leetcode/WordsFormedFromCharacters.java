package com.nirvana.learning.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KrishnaV
 */
public class WordsFormedFromCharacters {
    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words,chars));
    }
    public static int countCharacters(String[] words, String chars) {
        int sum = 0;
        for(String word: words){
            boolean flag = true;
            Map<String, Integer> charMap = getStringIntegerMap(chars);
            for(char ch: word.toCharArray()){
                if(charMap.containsKey(String.valueOf(ch)) && charMap.get(String.valueOf(ch))>=0){
                    charMap.put(String.valueOf(ch),charMap.get(String.valueOf(ch))-1);
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                sum+= word.length();
            }
        }
        return sum;

    }

    public static Map<String, Integer> getStringIntegerMap(String chars) {
        Map<String,Integer> charMap = new HashMap<>();
        for(char ch: chars.toCharArray()){
            if(charMap.containsKey(String.valueOf(ch))){
                charMap.put(String.valueOf(ch),charMap.get(String.valueOf(ch))+1);
            } else{
                charMap.put(String.valueOf(ch),0);
            }
        }
        return charMap;
    }
}
