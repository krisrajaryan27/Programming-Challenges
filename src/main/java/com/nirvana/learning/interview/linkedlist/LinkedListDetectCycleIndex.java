package com.nirvana.learning.interview.linkedlist;

/**
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list
 * that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * <p>
 * Do not modify the linked list.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * <p>
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * <p>
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: no cycle
 * <p>
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Constraints:
 * <p>
 * The number of the nodes in the list is in the range [0, 104]. <p>
 * -105 <= Node.val <= 105 <p>
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListDetectCycleIndex {
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null; // An empty list has no cycle
        }

        ListNode slow = head; // Tortoise
        ListNode fast = head; // Hare

        // First step: Determine if there is a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2

            // If they meet, there is a cycle
            if (slow == fast) {
                // Second step: Find the entry point of the cycle
                ListNode entry = head; // Start from the head
                while (entry != slow) {
                    entry = entry.next; // Move entry pointer
                    slow = slow.next; // Move slow pointer
                }
                return entry; // The entry point of the cycle
            }
        }

        return null; // No cycle found
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

        ListNode cycleStart = detectCycle(node1);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val); // Output: Cycle starts at node with value: 2
        } else {
            System.out.println("No cycle"); // Output: No cycle
        }
    }

}
