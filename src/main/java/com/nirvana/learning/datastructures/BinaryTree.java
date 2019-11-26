package com.nirvana.learning.datastructures;

/**
 * @author KrishnaV on 14/11/19
 * @project Programming-Challenges
 */
public class BinaryTree {
    static Node root;
    static int level_so_far = 0;
    void leftViewOfTree(Node node, int level){
      if(node == null)
          return;
      if(level > level_so_far){
          System.out.print(" "+node.data);
          level_so_far = level;
      }
      leftViewOfTree(node.left, level+1);
      leftViewOfTree(node.right,level+1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root= new Node(12);
        tree.root.left= new Node(10);
        tree.root.right= new Node(30);
        tree.root.right.left= new Node(25);
        tree.root.right.right= new Node(40);
        tree.leftViewOfTree(root,1);
        
    }
    
}

class Node{
    int data;
    Node left,right;
    public Node(int item){
        data = item;
        left = right = null;
    }
}
