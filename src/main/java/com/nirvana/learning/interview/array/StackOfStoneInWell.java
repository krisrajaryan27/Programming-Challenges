package com.nirvana.learning.interview.array;

import java.util.Arrays;

/**
 * @author KrishnaV on 21/11/19
 * @project Programming-Challenges
 */
public class StackOfStoneInWell {
    public static void main(String[] args) {
        int[] stoneStack1 = {5, 4, 9, 20, 1};
        int[] wellDiameter1 = {7, 9, 1, 25, 6, 7};
        int[] stoneStack2 = {2, 3, 5, 2, 4};
        int[] wellDiameter2 = {5, 6, 4, 3, 6, 2, 3};
        System.out.println(maxStonesToFit(wellDiameter1, stoneStack1));
        System.out.println(maxStonesToFit(wellDiameter2, stoneStack2));
    }

    public static int maxStonesToFit(int[] wellDiameter, int[] stoneStack) {
        int min = wellDiameter[0];
        int countNoOfStonesToFit = 0;

        // Find minimum of diameter till each index of well.
        for (int i = 0; i < wellDiameter.length; i++) {
            if (wellDiameter[i] < min) min = wellDiameter[i];
            if (wellDiameter[i] > min) wellDiameter[i] = min;
        }
        System.out.println("Processed Well Diameter Now : ");
        Arrays.stream(wellDiameter).forEach(value -> System.out.print(value + " "));
        System.out.println();
        for (int i = wellDiameter.length - 1; i >= 0; i--) {
            if (stoneStack[countNoOfStonesToFit] <= wellDiameter[i]) countNoOfStonesToFit++;
            if (countNoOfStonesToFit == stoneStack.length) break;
        }

        return countNoOfStonesToFit;
    }
}
