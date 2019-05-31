package com.nirvana.learning.hackerrank;

public class RectanglesFormed {

    static int countRect(int n)
    {
        int ans = 0;

        for (int length = 1; length <= Math.sqrt(n);
             ++length)
            for (int height = length; height*length <= n;
                 ++height)
                // height >= length is maintained
                ans++;

        return ans;
    }

    //driver code
    public static void main (String[] args)
    {
        int n = 21;

        System.out.print(countRect(n));
    }
}
