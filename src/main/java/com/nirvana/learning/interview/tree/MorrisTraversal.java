package com.nirvana.learning.interview.tree;

/**
 * Date 03/08/2019
 *
 * @author Krishna Verma
 * <p>
 * Morris inorder/preorder traversals
 * <p>
 * Time complexity O(n)
 * Space complexity O(1)
 */
public class MorrisTraversal {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(50, root);
        root = bt.addNode(-10, root);
        root = bt.addNode(7, root);
        root = bt.addNode(9, root);
        root = bt.addNode(-20, root);
        root = bt.addNode(30, root);
        MorrisTraversal mt = new MorrisTraversal();
        mt.inorder(root);
        System.out.println();
        mt.preorder(root);
    }

    public void inorder(Node root) {
        Node current = root;
        while (current != null) {
            //left is null then print the node and go to right
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                //find the predecessor.
                Node predecessor = current.left;
                //To find predecessor keep going right till right node is not null or right node is not current.
                while (predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                //if right node is null then go left after establishing link from predecessor to current.
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else { //left is already visit. Go rigth after visiting current.
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    public void preorder(Node root) {
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                Node predecessor = current.left;
                while (predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    System.out.print(current.data + " ");
                    current = current.left;
                } else {
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }
}
