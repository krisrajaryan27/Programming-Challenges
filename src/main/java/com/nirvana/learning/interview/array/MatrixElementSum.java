package com.nirvana.learning.interview.array;

/**
 * Given matrix, a rectangular matrix of integers, where each value represents the cost of the room,
 * your task is to return the total sum of all rooms that are suitable for the CodeBots
 * (ie: add up all the values that don't appear below a 0).
 * Example
 * For matrix = [[0, 1, 1, 2],
 * [0, 5, 0, 0],
 * [2, 0, 3, 3]]
 * the output should be
 * matrixElementsSum(matrix) = 9.
 * <p>
 * For matrix = [[1, 1, 1, 0],
 * [0, 5, 0, 1],
 * [2, 1, 3, 10]]
 * the output should be
 * matrixElementsSum(matrix) = 9
 */
public class MatrixElementSum {
    public static void main(String[] args) {
        int[][] matrix1 = {{0, 1, 1, 2}, {0, 5, 0, 0}, {2, 0, 3, 3}};
        int[][] matrix2 = {{1, 1, 1, 0}, {0, 5, 0, 1}, {2, 1, 3, 10}};
        System.out.println(matrixElementsSumBrute(matrix1));
        System.out.println(matrixElementsSum(matrix2));

    }

    private static int matrixElementsSumBrute(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
                if (arr[i][j] == 0) {
                    updateArray(arr, j);
                }
            }
        }
        return sum;
    }

    private static void updateArray(int[][] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][num] = 0;
        }
    }


    private static int matrixElementsSum(int[][] matrix) {
        int s = 0;
        for (int c = 0; c < matrix[0].length; ++c)
            for (int r = 0; r < matrix.length; ++r) {
                if (matrix[r][c] > 0)
                    s += matrix[r][c];
                else break;
            }
        return s;
    }

}
