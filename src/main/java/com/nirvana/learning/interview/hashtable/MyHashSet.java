package com.nirvana.learning.interview.hashtable;

import java.util.LinkedList;
import java.util.List;

/***
 * Design a HashSet without using any built-in hash table libraries.
 * <p>
 * Implement MyHashSet class:
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet.
 * If key does not exist in the HashSet, do nothing.
 * <p>
 * Example 1:
 * Input
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * Output
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * Explanation
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found)
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // return True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // return False, (already removed)
 * <p>
 * Constraints:
 * 0 <= key <= 106
 * At most 104 calls will be made to add, remove, and contains.
 * **/
public class MyHashSet {
    private static final int SIZE = 1000; // Size of the hash table
    private final List<Integer>[] table;

    public MyHashSet() {
        table = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False
    }

    private int hash(int key) {
        return key % SIZE; // Simple hash function
    }

    public void add(int key) {
        int index = hash(key);
        if (!table[index].contains(key)) {
            table[index].add(key); // Add key if it doesn't exist
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        return table[index].contains(key); // Check if key exists
    }

    public void remove(int key) {
        int index = hash(key);
        table[index].remove(Integer.valueOf(key)); // Remove key if it exists
    }
}
