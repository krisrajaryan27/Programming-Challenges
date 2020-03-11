package com.nirvana.learning.educative;

import java.util.*;

class PriorityExpiryCacheMain {
    public static void main(String[] args) {
        PriorityExpiryCache priorityExpiryCache = new PriorityExpiryCache(5);
        priorityExpiryCache.setItem(new Item("A", "val1", 5, 100), 0);
        priorityExpiryCache.setItem(new Item("B", "val2", 15, 3), 0);
        priorityExpiryCache.setItem(new Item("C", "val3", 5, 10), 0);
        priorityExpiryCache.setItem(new Item("D", "val4", 1, 15), 0);
        priorityExpiryCache.setItem(new Item("E", "val5", 5, 150), 0);

        priorityExpiryCache.getItem("C");

        System.out.println(priorityExpiryCache.getKeys());

        priorityExpiryCache.evictItem(5);
        System.out.println(priorityExpiryCache.getKeys());

        priorityExpiryCache.evictItem(5);
        System.out.println(priorityExpiryCache.getKeys());

        priorityExpiryCache.evictItem(5);
        System.out.println(priorityExpiryCache.getKeys());

        priorityExpiryCache.evictItem(5);
        System.out.println(priorityExpiryCache.getKeys());
    }
}

/**
 * Variant of LRU Cache - Asked in Tesla
 * The PriorityExpiryCache has the following methods that can be invoked:
 * 1. get(String key)
 * 2. set(String key, String value, int priority, int expiry)
 * 3. evictItem(int currentTime)
 * <p>
 * The rules by which the cache operates is are follows:
 * 1. If an expired item is available. Remove it. If multiple items have the same expiry, removing any one suffices.
 * 2. If condition #1 can't be satisfied, remove an item with the least priority.
 * 3. If more than one item satisfies condition #2, remove the least recently used one.
 * <p>
 * Whenever looking for max/min among set of values, likely choice of DS is Heap (called as PriorityQueue)
 * as it provides O(1) look-up (not removal) for max/min value.
 * Removal from min-heap = O(logn)
 * <p>
 * Whenever need to order entities, use linkedList
 * Whenever need collection of entities without order, use set
 * DoublyLinkedList - used to determine predecessor for a node in constant time O(1)
 */

public class PriorityExpiryCache {
    int maxSize;
    int currSize;
    PriorityQueue<ListNode<Item>> priorityQueueByExpiryTime = new PriorityQueue<>(Comparator.comparingInt(a -> a.data.expireAfter));
    PriorityQueue<ListNode<Item>> priorityQueueByPreference = new PriorityQueue<>(Comparator.comparingInt(a -> a.data.preference));
    HashMap<Integer, DoublyLinkedList<Item>> preferrenceToList = new HashMap<>();
    HashMap<String, ListNode<Item>> keyToItemNode = new HashMap<>();

    public PriorityExpiryCache(int maxSize) {
        this.maxSize = maxSize;
        this.currSize = 0;
    }

    public Set<String> getKeys() {
        return keyToItemNode.keySet();
    }

    /**
     * 1. Remove all expired items first
     * 2. If none are expired, evict the ones with lowest preference
     * 3. If there's a tie on items with least preference, evict the ones
     * which are least recently used.
     */
    public void evictItem(int currentTime) {
        if (currSize == 0) return;
        currSize--;

        // Check expired items first
        assert priorityQueueByExpiryTime.peek() != null;
        if (priorityQueueByExpiryTime.peek().data.expireAfter < currentTime) {
            ListNode<Item> itemListNode = priorityQueueByExpiryTime.poll();
            Item item = itemListNode.data;
            DoublyLinkedList<Item> itemDoublyLinkedList = preferrenceToList.get(item.preference);
            itemDoublyLinkedList.removeNode(itemListNode);

            // Remove from hashmap too
            if (itemDoublyLinkedList.size() == 0) {
                preferrenceToList.remove(item.preference);
            }

            // Remove from hashmap
            keyToItemNode.remove(item.key);

            // Remove from preference queue too
            priorityQueueByPreference.remove(itemListNode);
            return;
        }
        // Next check if preference items are to be removed
        int preference = Objects.requireNonNull(priorityQueueByPreference.poll()).data.preference;

        DoublyLinkedList<Item> itemDoublyLinkedList = preferrenceToList.get(preference);

        // Remove the end
        ListNode<Item> leastRecentlyUsedWithLeastPreference = itemDoublyLinkedList.removeLast();
        keyToItemNode.remove(leastRecentlyUsedWithLeastPreference.data.key);

        // Remove from the expiry queue
        priorityQueueByExpiryTime.remove(leastRecentlyUsedWithLeastPreference);


        if (itemDoublyLinkedList.size() == 0) {
            // Remove the itemDoublyLinkedList too
            preferrenceToList.remove(itemDoublyLinkedList);
        }
    }

    /**
     * Get the value of the key if the key exists in the cache and isn't expired.
     */
    public Item getItem(String key) {
        if (keyToItemNode.containsKey(key)) {
            ListNode<Item> node = keyToItemNode.get(key);
            Item itemToReturn = node.data;

            DoublyLinkedList<Item> itemDoublyLinkedList = preferrenceToList.get(itemToReturn.preference);
            itemDoublyLinkedList.removeNode(node);
            itemDoublyLinkedList.addFront(itemToReturn);
            return itemToReturn;
        }
        return null;
    }

    /**
     * update or insert the value of the key with a preference value and expire time.
     * Set should never allow more items than maxItems to be in the cache. When evicting
     * we need to evict the lowest preference item(s) which are least recently used.
     */
    public void setItem(Item item, int currentTime) {

        if (currSize == maxSize) {
            evictItem(currentTime);
        }

        // Get the linkedlist for the preference queue
        DoublyLinkedList<Item> itemDoublyLinkedList;
        if (preferrenceToList.containsKey(item.preference)) {
            itemDoublyLinkedList = preferrenceToList.get(item.preference);
        } else {
            itemDoublyLinkedList = new DoublyLinkedList<>();
            preferrenceToList.put(item.preference, itemDoublyLinkedList);
        }

        ListNode<Item> node = itemDoublyLinkedList.addFront(item);
        keyToItemNode.put(item.key, node);

        // Update the expiry time pqueue
        priorityQueueByExpiryTime.add(node);

        // Update the preference pqueue
        priorityQueueByPreference.add(node);

        currSize++;
    }

}

class Item {
    int preference;
    int expireAfter;
    String key;
    String value;

    public Item(String key, String value, int priority, int expireAfter) {
        this.preference = priority;
        this.expireAfter = expireAfter;
        this.key = key;
        this.value = value;
    }
}

class ListNode<T> {
    T data;
    ListNode<T> next;
    ListNode<T> prev;

    ListNode(T data) {
        this(null, data, null);
    }

    ListNode(ListNode<T> prev, T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList<T> {

    private ListNode<T> front;
    private ListNode<T> end;
    private int size;

    public DoublyLinkedList() {
        end = front = null;
    }

    public ListNode<T> addFront(T x) {
        ListNode<T> retVal;
        if (size == 0) {
            front = new ListNode<>(x);
            end = front;
            retVal = front;
        } else {
            ListNode<T> newNode = new ListNode<>(null, x, null);
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
            retVal = newNode;
        }
        size++;
        return retVal;
    }

    ListNode<T> removeLast() {
        ListNode<T> item = end;
        end = end.prev;
        size--;
        return item;
    }

    public void removeNode(ListNode<T> node) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            end = front = node = null;
        } else {
            ListNode<T> prev = node.prev;
            ListNode<T> next = node.next;
            if (prev != null)
                prev.next = next;
            if (next != null)
                next.prev = prev;
            node = null;
        }
        size--;
    }

    public int size() {
        return size;
    }
}


