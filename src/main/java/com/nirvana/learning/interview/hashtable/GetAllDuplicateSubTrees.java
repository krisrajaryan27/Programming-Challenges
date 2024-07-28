package com.nirvana.learning.interview.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Given the root of a binary tree, return all duplicate subtrees.
 * <p>
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * <p>
 * Two trees are duplicate if they have the same structure with the same node values.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 * Example 2:
 * <p>
 * Input: root = [2,1,1]
 * Output: [[1]]
 * Example 3:
 * <p>
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 * <p>
 * Constraints:
 * <p>
 * The number of the nodes in the tree will be in the range [1, 5000]
 * <p>
 * -200 <= Node.val <= 200
 * */
public class GetAllDuplicateSubTrees {
    private static final Map<String, Integer> subtreeCount = new HashMap<>();
    private static final List<TreeNode> duplicates = new ArrayList<>();

    public static void main(String[] args) {
        // Example usage
        // Construct the tree [1,2,3,4,null,2,4,null,null,4]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.right.left = new TreeNode(2);
        root1.right.left.left = new TreeNode(4);
        root1.right.left.left.left = new TreeNode(4);

        List<TreeNode> duplicates1 = findDuplicateSubtrees(root1);
        for (TreeNode node : duplicates1) {
            System.out.println(node.value); // Output the root values of duplicate subtrees
        }

        // Construct the tree [2,1,1]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);

        List<TreeNode> duplicates2 = findDuplicateSubtrees(root2);
        for (TreeNode node : duplicates2) {
            System.out.println(node.value); // Output the root values of duplicate subtrees
        }

        // Construct the tree [2,2,2,3,null,3,null]
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.right.right = new TreeNode(3);

        List<TreeNode> duplicates3 = findDuplicateSubtrees(root3);
        for (TreeNode node : duplicates3) {
            System.out.println(node.value); // Output the root values of duplicate subtrees
        }
    }

    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subtreeCount.clear();
        duplicates.clear();
        serializeTree(root);
        return duplicates;
    }

    private static String serializeTree(TreeNode node) {
        if (node == null) {  // Use '#' to represent null
            return "#";
        }

        // Serialize the current subtree
        String serial = node.value + "," + serializeTree(node.left) + "," + serializeTree(node.right);

        // Count the occurrences of the serialized subtree
        subtreeCount.put(serial, subtreeCount.getOrDefault(serial, 0) + 1);

        // If this is the second time we've seen this subtree, add it to the result
        if (subtreeCount.get(serial) == 2) {
            duplicates.add(node);
        }
        return serial;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }
}
