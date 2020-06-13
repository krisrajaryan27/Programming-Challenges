package com.nirvana.learning.codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author KrishnaV
 */
public class Lecandy {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        try {

            int testCases = Integer.parseInt(bReader.readLine());
            int[] numOfElephantCases = new int[testCases];
            int[] numOfCandyCases = new int[testCases];
            boolean[] boolCases = new boolean[testCases];
            for (int i = 0; i < testCases; i++) {
                String[] line = bReader.readLine().split("\\s+");

                numOfElephantCases[i] = Integer.parseInt(line[0]);

                numOfCandyCases[i] = Integer.parseInt(line[1]);

                String[] candiesPerElephantString = bReader.readLine().split("\\s+");
                int sum = 0;
                for (String c : candiesPerElephantString) {
                    sum += Integer.parseInt(c);

                }
                boolCases[i] = sum <= numOfCandyCases[i];
            }

            if (boolCases.length > 0) {
                for (boolean i : boolCases) {
                    if (i)
                        System.out.println("Yes");
                    else
                        System.out.println("No");
                }
            }
            bReader.close();
        } catch (Exception e) {
            bReader.close();
        }
    }
}
