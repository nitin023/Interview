package com.cracking.coding.interview.leetcode.topinterview.easy;

import com.cracking.coding.interview.LinkedList.ListNode;

/**
 *
 * Finding middle of the linked list using slow - fast ptr approach
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slowPtr = head, fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }
}
