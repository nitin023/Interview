package com.cracking.coding.interview.leetcode.topinterview.easy;

import com.cracking.coding.interview.LinkedList.ListNode;

public class MergeTwoLinkedList {
    public static ListNode mergeTwoListsIteratively(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int l1HeadVal = l1.val;

        int l2HeadVal = l2.val;

        ListNode mergedList;

        if (l1HeadVal < l2HeadVal) {
            mergedList = new ListNode(l1HeadVal);
            l1 = l1.next;
        } else {
            mergedList = new ListNode(l2HeadVal);
            l2 = l2.next;
        }

        ListNode headPtr = mergedList;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                headPtr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                headPtr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            headPtr = headPtr.next;
        }

        while (l1 != null) {
            headPtr.next = new ListNode(l1.val);
            headPtr = headPtr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            headPtr.next = new ListNode(l2.val);
            headPtr = headPtr.next;
            l2 = l2.next;
        }
        return mergedList;
    }
}
