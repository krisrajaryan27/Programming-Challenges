package com.nirvana.learning.interview.tree;

/**
 * Date 10/06/2019
 *
 * @author Krishna Verma
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * Time complexity O(logn)
 * <p>
 * Reference
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class HeightBalanced {
    public boolean isBalanced(Node root) {
        return isBalancedUtil(root) >= 0;
    }

    private int isBalancedUtil(Node root) {
        if (root == null) {
            return 0;
        }
        int left = isBalancedUtil(root.left);
        if (left < 0) {
            return -1;
        }
        int right = isBalancedUtil(root.right);
        if (right < 0) {
            return -1;
        }
        int diff = Math.abs(left - right);
        return diff <= 1 ? (Math.max(left, right) + 1) : -1;
    }
}
