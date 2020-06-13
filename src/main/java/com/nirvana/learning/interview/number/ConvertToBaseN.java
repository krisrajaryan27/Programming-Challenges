package com.nirvana.learning.interview.number;

public class ConvertToBaseN {

    public static void main(String[] args) {
        ConvertToBaseN ctb = new ConvertToBaseN();
        System.out.println(ctb.baseN(13, 9));
    }

    int baseN(int num, int base) {
        if (base > 10) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        int pow = 1;
        while (num > 0) {
            result += pow * (num % base);
            pow = pow * 10;
            num /= base;
        }
        return result;
    }
}
