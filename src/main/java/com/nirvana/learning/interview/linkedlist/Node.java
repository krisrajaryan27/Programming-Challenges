package com.nirvana.learning.interview.linkedlist;

public class Node {
    int data;
    Node next;
    Node before;
    Node child;
    Object obj;

    public static Node newNode(int data, Object... obj) {
        Node n = new Node();
        n.data = data;
        n.next = null;
        n.before = null;
        if (obj.length > 0) {
            n.obj = obj[0];
        }
        return n;
    }
}