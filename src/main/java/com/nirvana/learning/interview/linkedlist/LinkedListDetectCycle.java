package com.nirvana.learning.interview.linkedlist;

/**
 * Given head, the head of a linked list,
 * determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node
 * in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote
 * the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * <p>
 * Explanation:
 * There is a cycle in the linked list, where the tail connects to the 0th node.
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * <p>
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Constraints:
 * <p>
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * <p>
 */
public class LinkedListDetectCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false; // An empty list has no cycle
        }

        ListNode fast = head; // Tortoise
        ListNode slow = head; // Hare

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2

            // If they meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }
        return false; // No cycle found
    }

    public static void main(String[] args) {
        // Create nodes
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Set up the linked list with a cycle
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle

        System.out.println(hasCycle(node1)); // Output: true
    }
}
