package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

import com.cracking.coding.interview.LinkedList.ListNode;

/**
 * Easy
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeTwoListsHelper(l1, l2);
    }

    private ListNode mergeTwoListsHelper(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsHelper(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsHelper(l1, l2.next);
            return l2;
        }
    }
}
