package com.nirvana.learning.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&playlist_slugs%5B%5D=virtusa
 *
 * @author Krishna Verma
 */
public class PairsSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        int result = pairs(k, arr);
        System.out.println(result);
    }

    private static int pairs(int difference, int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + difference == arr[j]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
