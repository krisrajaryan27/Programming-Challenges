package com.nirvana.learning.educative.datastructures.trees;

/**
 * Given the root to a Binary Search Tree and a value "k", write a function to find the nodes at "k" distance from the root.
 *
 * @author Krishna Verma
 */
public class NodesAtKDistanceFromRootBST {
    public static void main(String[] args) {
        BinarySearchTree bsT = new BinarySearchTree();


        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);

        System.out.println(findKNodes(bsT.getRoot(), 2));
    }

    public static String findKNodes(Node root, int k) {

        StringBuilder result = new StringBuilder(); //StringBuilder is immutable
        result = findK(root, k, result);

        return result.toString();
    }

    //Helper recursive function to traverse tree and append all the nodes
    // at k distance into result StringBuilder
    public static StringBuilder findK(Node root, int k, StringBuilder result) {

        if (root == null) return null;

        if (k == 0) {
            result.append(root.getData() + ",");
        } else {
            //Decrement k at each step till you reach at the leaf node
            // or when k == 0 then append the Node's data into result string
            findK(root.getLeftChild(), k - 1, result);
            findK(root.getRightChild(), k - 1, result);
        }
        return result;
    }
}
