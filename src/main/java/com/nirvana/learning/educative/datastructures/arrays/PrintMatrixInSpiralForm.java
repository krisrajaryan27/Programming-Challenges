package com.nirvana.learning.educative.datastructures.arrays;

/**
 * Given a 2D array, print it in spiral form.
 * Input:  1    2   3   4
 * 5    6   7   8
 * 9   10  11  12
 * 13  14  15  16
 * Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * Explanation: The output is matrix in spiral format.
 * <p>
 * Input:  1   2   3   4  5   6
 * 7   8   9  10  11  12
 * 13  14  15 16  17  18
 * Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 * Explanation :The output is matrix in spiral format.
 */
public class PrintMatrixInSpiralForm {
    public static void main(String[] args) {
        int R = 3;
        int C = 6;
        int a[][] = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}};
        spiralPrint(R, C, a);
    }

    private static void spiralPrint(int row, int col, int[][] a) {
        int i, k = 0, l = 0;
        while (k < row && l < col) {
            for (i = l; i < col; i++) {
                System.out.print(a[k][i] + " ");
            }
            k++;
            for (i = k; i < row; i++) {
                System.out.print(a[i][col - 1] + " ");
            }
            col--;
            if (k < row) {
                for (i = col - 1; i >= l; i--) {
                    System.out.print(a[row - 1][i] + " ");
                }
                row--;
            }
            if (l < col) {
                for (i = row - 1; i >= k; i--) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }
}
