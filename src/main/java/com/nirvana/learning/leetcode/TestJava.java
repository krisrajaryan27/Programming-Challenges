package com.nirvana.learning.leetcode;
class recursion{
    int func(int n){
        int result;
        result = func(n-1);
        return result;
    }
}
public class TestJava {
    public static void main(String[] args) {
        /*Integer[][] str = {{null}};
        System.out.println(str[0][1].intValue());*/
        recursion obj = new recursion();
        System.out.println(obj.func(12));
    }
}
