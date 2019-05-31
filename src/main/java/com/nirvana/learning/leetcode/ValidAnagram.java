package com.nirvana.learning.leetcode;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] counts= new int[26];
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
            counts[t.charAt(i)-'a']--;
        }

        for(int i:counts){
            if(i!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="krishna";
        String t="rishnak";
        System.out.println("Both Strings are anagram of each other: "+isAnagram(s,t));
    }
}
