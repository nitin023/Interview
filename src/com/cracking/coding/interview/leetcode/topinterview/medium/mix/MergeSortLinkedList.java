package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

import com.cracking.coding.interview.LinkedList.ListNode;

import static com.cracking.coding.interview.leetcode.topinterview.easy.MergeTwoLinkedList.mergeTwoListsIteratively;

/**
 * This whole solution is based on two following operations
 * a) Split the list into two lists
 * b) Get the middle node
 * c) Sort the head..middle and middle.next...tail
 * d) Merge the two sorted list to give sorted list
 * c) Done without extra memory constraint (O log N)
 */
public class MergeSortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tailNode = getTailNode(head);
        return mergeSorter(head, tailNode);
    }

    private ListNode getTailNode(ListNode head) {
        ListNode node = head;

        while (node.next != null) {
            node = node.next;
        }

        return node;
    }

    private ListNode getMiddleNode(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeSorter(ListNode head, ListNode tail) {
        if (head == tail) {
            return new ListNode(head.val);
        }

        ListNode middleNode = getMiddleNode(head, tail);
        ListNode leftList = mergeSorter(head, middleNode);
        ListNode rightList = mergeSorter(middleNode.next, tail);

        return mergeTwoListsIteratively(leftList, rightList);
    }
}
