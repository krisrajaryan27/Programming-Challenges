package com.nirvana.learning.interview.linkedlist;

/**
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect. If the two linked lists
 * have no intersection at all, return null.
 * <p>
 * For example, the following two linked lists begin to intersect at node c1:
 * <p>
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * <p>
 * Note that the linked lists must retain their original structure after the function returns.
 * <p>
 * Custom Judge:
 * <p>
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * <p>
 * intersectVal - The value of the node where the intersection occurs.
 * This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head)
 * to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head)
 * to get to the intersected node.
 * The judge will then create the linked structure based on these inputs
 * and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0
 * if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B,
 * it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A;
 * There are 3 nodes before the intersected node in B.
 * - Note that the intersected node's value is not 1
 * because the nodes with value 1 in A and B (2nd node in A and 3rd node in B)
 * are different node references. In other words, they point to two different
 * locations in memory, while the nodes with value 8 in A and B
 * (3rd node in A and 4th node in B) point to the same location in memory.
 * Example 2:
 * <p>
 * <p>
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0
 * if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B,
 * it reads as [3,2,4]. There are 3 nodes before the intersected node in A;
 * There are 1 node before the intersected node in B.
 * Example 3:
 * <p>
 * <p>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B,
 * it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0,
 * while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 1 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA < m
 * 0 <= skipB < n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 * <p>
 * <p>
 * Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
 * <p>
 * <a href="https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/">Leetcode</a>
 */
public class LinkedListIntersection {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null; // If either list is empty, there can be no intersection
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists
        while (pointerA != pointerB) {
            // When reaching the end of one list, switch to the head of the other
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // If they intersect, pointerA and pointerB will point to the intersection node
        // If they don't intersect, both will be null at the end of the loop
        return pointerA;
    }

    public static void main(String[] args) {
        // Create nodes for list A
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        // Create nodes for list B
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(1);

        // Set up the linked lists
        node1.next = node2;
        node2.next = node3; // Intersection starts here
        node3.next = node4;
        node4.next = node5;

        node6.next = node7;
        node7.next = node8;
        node8.next = node3; // Intersects at node3

        ListNode intersectionNode = getIntersectionNode(node1, node6);

        if (intersectionNode != null) {
            System.out.println("Intersected at '" + intersectionNode.val + "'"); // Output: Intersected at '8'
        } else {
            System.out.println("No intersection");
        }
    }

}
