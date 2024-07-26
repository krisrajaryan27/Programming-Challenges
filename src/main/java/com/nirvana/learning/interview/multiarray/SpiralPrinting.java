package com.nirvana.learning.interview.multiarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date 03/15//2018
 *
 * @author Krishna Verma
 * <p>
 * Given a 2D matrix(square or rectangular) print it in spiral way.
 * e.g 1 2 3
 * 4 5 6
 * 7 8 9
 * Printing should be 1 2 3 6 9 8 7 4 5
 * <p>
 * ConvertSortedArrayToBinarySearchTree:
 * Keep 4 pointers which are bounds for this matrix, up, down, left, right. Print each
 * row or column and keep incrementing and decrementing the bounds. As soon as up meets down
 * or left meets right we are done.
 * <p>
 * Reference
 * https://leetcode.com/problems/spiral-matrix/
 * http://stackoverflow.com/questions/726756/print-two-dimensional-array-in-spiral-order
 * http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
public class SpiralPrinting {

    public static void main(String[] args) {
        SpiralPrinting sp = new SpiralPrinting();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> result = sp.spiralOrder(matrix);
        System.out.print(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;

        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;

            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
            }
            down--;

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }
        return result;
    }

    public List<Integer> spiralOrderList(List<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0 || A.get(0).size() == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = A.get(0).size() - 1;
        int up = 0;
        int down = A.size() - 1;

        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                result.add(A.get(up).get(i));
            }
            up++;

            for (int i = up; i <= down; i++) {
                result.add(A.get(i).get(right));
            }
            right--;

            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result.add(A.get(down).get(i));
                }
            }
            down--;

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result.add(A.get(i).get(left));
                }
            }
            left++;
        }
        return result;
    }
}
