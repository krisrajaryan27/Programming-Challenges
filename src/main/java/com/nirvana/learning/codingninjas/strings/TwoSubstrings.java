package com.nirvana.learning.codingninjas.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoSubstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine().trim();
        boolean f1=false,s1=false;
        int i;

        for(i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='A' && s.charAt(i+1)=='B')
            {
                i+=2;f1=true;
                break;
            }
        }

        for(int j=i;j<s.length()-1;j++)
        {
            if(s.charAt(j)=='B' && s.charAt(j+1)=='A')
            {
                s1=true;
                break;
            }

        }

        boolean f2=false,s2=false;
        for(i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='B' && s.charAt(i+1)=='A')
            {
                i+=2;s2=true;
                break;
            }
        }

        for(int j=i;j<s.length()-1;j++)
        {
            if(s.charAt(j)=='A' && s.charAt(j+1)=='B')
            {
                f2=true;
                break;
            }
        }

        //System.out.println(f1+" "+s1+" "+f2+" "+s2);

        if((f1 && s1) || (f2 && s2))
            System.out.println("yes");
        else
            System.out.println("no");

    }
}
