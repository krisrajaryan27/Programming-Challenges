package com.nirvana.learning.interview.hashtable;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
    private static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 1000; // Size of the hash table
    private final List<Entry>[] table;

    public MyHashMap() {
        table = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1)); // return 1
        System.out.println(myHashMap.get(3)); // return -1 (not found)
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]]
        System.out.println(myHashMap.get(2)); // return 1
        myHashMap.remove(2); // remove the mapping for 2
        System.out.println(myHashMap.get(2)); // return -1 (not found)
    }

    private int hash(int key) {
        return key % SIZE; // Simple hash function
    }

    public void put(int key, int value) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                entry.value = value; // Update existing value
                return;
            }
        }
        table[index].add(new Entry(key, value)); // Add new key-value pair
    }

    public int get(int key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                return entry.value; // Return the value if found
            }
        }
        return -1; // Key not found
    }

    public void remove(int key) {
        int index = hash(key);
        Entry toRemove = null;
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                toRemove = entry; // Mark the entry for removal
                break;
            }
        }
        if (toRemove != null) {
            table[index].remove(toRemove); // Remove the entry
        }
    }
}
