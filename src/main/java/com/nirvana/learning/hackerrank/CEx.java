package com.nirvana.learning.hackerrank;


class Base1 {}
class Sub extends Base1 {}
class Sub2 extends Base1 {}
public class CEx {
    public static void main(String[] args) {
        Base1 b = new Base1();
        Sub sub= (Sub)b;
    }
}
