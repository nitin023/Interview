package com.cracking.coding.interview.LinkedList;

/**
 * 2.7 Find intersection of two linked list when the linked list meet at a point
 * Easy
 * https://leetcode.com/problems/intersection-of-two-linked-lists
 * Solution Approach :
 *
 * 1)LinkedList intersecting at a node would have same tail node
 * 2) If the length of two such linked list is equal then directly iterate them and find intersecting node
 * 3) If the length differ then identify the longer and shorter linked list
 * 4) Remove extra nodes from longer linked list by keep moving longer list to new nodes until length becomes equal
 * 5) When length becomes equal start comparing until both meet at a point
 * 6) The point of intersection is the meeting point
 *
 * Best solution with no extra space required O(n) constant space
 */
public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Result resultA = getTailAndLength(headA);
        Result resultB = getTailAndLength(headB);

        if (resultA.tail != resultB.tail) {
            return null;
        }

        ListNode longer = resultA.length < resultB.length ? headB : headA;
        ListNode shorter = resultA.length < resultB.length ? headA : headB;

        int diff = Math.abs(resultA.length - resultB.length);
        longer = removeGreyedNodesFromLongerList(longer, diff);

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }

    public Result getTailAndLength(ListNode node) {
        int length = 1;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        return new Result(node, length);
    }

    public ListNode removeGreyedNodesFromLongerList(ListNode longer, int diff) {
        ListNode current = longer;
        while (diff > 0 && current != null) {
            current = current.next;
            diff--;

        }
        return current;
    }

    public class Result {
        public ListNode tail;
        public int length;

        public Result(ListNode tail, int length) {
            this.tail = tail;
            this.length = length;
        }
    }
}
