package com.nirvana.learning.interview.hashtable;

import java.util.*;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * <p>
 * bool insert(int val): Inserts an item val into the set if not present.
 * Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present.
 * Returns true if the item was present, false otherwise.
 * <p>
 * int getRandom() :
 * Returns a random element from the current set of elements
 * (it's guaranteed that at least one element exists when this method is called).
 * Each element must have the same probability of being returned.
 * You must implement the functions of the class
 * such that each function works in average O(1) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * <p>
 * Output
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * Explanation:
 * <p>
 * RandomizedSet randomizedSet = new RandomizedSet();
 * <p>randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * <p>randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * <p>randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * <p>randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * <p>randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * <p>randomizedSet.insert(2); // 2 was already in the set, so return false.
 * <p>randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * <p>
 * Constraints:
 * <p>
 * -231 <= val <= 231 - 1
 * <p>At most 2 * 105 calls will be made to insert, remove, and getRandom.
 * <p>There will be at least one element in the data structure when getRandom is called.
 */
public class RandomizedSet {
    private final List<Integer> nums; // To store the elements
    private final Map<Integer, Integer> indexMap; // To store the index of each element

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nums = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Returns true
        System.out.println(randomizedSet.remove(2)); // Returns false
        System.out.println(randomizedSet.insert(2)); // Returns true
        System.out.println(randomizedSet.getRandom()); // Returns 1 or 2 randomly
        System.out.println(randomizedSet.remove(1)); // Returns true
        System.out.println(randomizedSet.insert(2)); // Returns false
        System.out.println(randomizedSet.getRandom()); // Returns 2
    }

    /**
     * Inserts an item val into the set if not present.
     * Returns true if the item was not present, false otherwise.
     */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false; // Element already exists
        }
        nums.add(val);
        indexMap.put(val, nums.size() - 1); // Store the index of the new element
        return true;
    }

    /**
     * Removes an item val from the set if present.
     * Returns true if the item was present, false otherwise.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false; // Element does not exist
        }
        // Get the index of the element to remove
        int index = indexMap.get(val);
        int lastElement = nums.get(nums.size() - 1);

        // Move the last element to the position of the element to remove
        nums.set(index, lastElement);
        indexMap.put(lastElement, index); // Update the index of the last element

        // Remove the last element
        nums.remove(nums.size() - 1);
        indexMap.remove(val); // Remove the element from the map
        return true;
    }

    /**
     * Get a random element from the current set of elements.
     */
    public int getRandom() {
        Random random = new Random();
        return nums.get(random.nextInt(nums.size())); // Get a random index
    }
}
