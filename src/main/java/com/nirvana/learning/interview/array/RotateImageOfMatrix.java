package com.nirvana.learning.interview.array;

/**
 * You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
 * For
 * a = [[1, 2, 3],
 * [4, 5, 6],
 * [7, 8, 9]]
 * the output should be
 * <p>
 * rotateImage(a) =
 * [[7, 4, 1],
 * [8, 5, 2],
 * [9, 6, 3]]
 */
public class RotateImageOfMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix = rotateImage(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " , ");
            }
            System.out.println("");
        }
    }

    private static int[][] rotateImage(int[][] matrix) {
        int N = matrix.length;
        //Transpose the matrix
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reverse image by column
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (N / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = temp;
            }
        }
        return matrix;

    }
}
