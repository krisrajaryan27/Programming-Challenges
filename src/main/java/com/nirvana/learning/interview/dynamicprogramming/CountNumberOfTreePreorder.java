package com.nirvana.learning.interview.dynamicprogramming;

/**
 * Given a preorder sequence how many unique trees can be created
 * ConvertSortedArrayToBinarySearchTree is catalan number. Number of tree is exactly same
 * as number of unique BST create with array of size n
 * <p>
 * The way it works for preorder sequence is as follows
 * <p>
 * Suppose our preorder sequence is 1 2 3 4
 * So we need to compute following things
 * count(3)* 2 (combination of 2,3 and 4 on both side of 1)
 * count(1)*count(2) (combination of 2 on one side and 3, 4 on other side)
 * count(2)*count(1) (combinatino of 2,3 on one side and 4 on other side)
 * count(3)*2 can be broken into count(3)*count(0) + count(0)*count(3)
 * <p>
 * So our final result is
 * count(0)*count(3) + count(1)*count(2) + count(2)*count(1) + count(3)*count(0)
 * which is a catalan number
 */
public class CountNumberOfTreePreorder {

    public static void main(String[] args) {
        CountNumberOfTreePreorder cn = new CountNumberOfTreePreorder();
        System.out.println(cn.count(3));
        System.out.println(cn.count(4));
        System.out.println(cn.count(5));
        System.out.println(cn.countRec(3));
        System.out.println(cn.countRec(4));
        System.out.println(cn.countRec(5));
    }

    public int count(int num) {
        if (num == 0) {
            return 0;
        }
        int[] T = new int[num + 1];
        T[0] = 1;
        T[1] = 1;
        for (int i = 2; i <= num; i++) {
            int sum = 0;
            for (int k = 0; k < i; k++) {
                sum += T[k] * T[i - k - 1];
            }
            T[i] = sum;
        }
        return T[num];
    }

    public int countRec(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += countRec(i - 1) * countRec(num - i);
        }
        return sum;
    }
}
