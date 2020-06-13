package com.nirvana.learning.hackerrank;

import java.util.Arrays;

public class NewYearChaos {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 7, 8, 6, 4};
        minimumBribes(arr);
    }

    static void minimumBribes(int[] q) {
        int[] visited = new int[q.length];
        Arrays.fill(visited, 0);
        int count = 0;
        for (int i = 0; i < q.length - 1; i++) {
            for (int j = i + 1; j < q.length; j++) {
                if (q[i] > q[j]) {
                    visited[i]++;
                    visited[j]++;
                    count++;
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] > 2) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(count);
        } else {
            System.out.println("Too chaotic");
        }


    }
}
