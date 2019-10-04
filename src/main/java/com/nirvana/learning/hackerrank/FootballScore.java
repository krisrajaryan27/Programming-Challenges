package com.nirvana.learning.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KrishnaV
 */
public class FootballScore {
    public static void main(String[] args) {
        List<Integer> teamA = new ArrayList<>();
        List<Integer> teamB = new ArrayList<>();
        teamA.add(1);
        teamA.add(2);
        teamA.add(3);
        teamB.add(2);
        teamB.add(4);
        List<Integer> result = count(teamA,teamB);
        System.out.println(result);
    }

    private static List<Integer> count(List<Integer> teamA, List<Integer> teamB) {
        long time = System.currentTimeMillis();
        System.out.println(time);
        List<Integer> result = new ArrayList<>();
        teamB.stream().forEach(value -> {
            result.add((int) teamA.stream().filter(val -> val<=value).count());
        });
        System.out.println(System.currentTimeMillis() - time);
        return result;
    }

}
