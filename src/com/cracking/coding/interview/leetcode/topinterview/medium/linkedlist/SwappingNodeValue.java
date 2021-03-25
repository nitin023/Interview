package com.cracking.coding.interview.leetcode.topinterview.medium.linkedlist;

import com.cracking.coding.interview.LinkedList.ListNode;

/**
 * Medium
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list
 */
public class SwappingNodeValue {
    public ListNode swapNodes(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        //get nodes from list

        ListNode nodeFromBeg = null;
        ListNode nodeFromEnd = null;

        ListNode node = head;

        int allNodesCount = 0;

        while (node != null) {
            node = node.next;
            allNodesCount++;
        }

        node = head;

        int nodeIndexFromEnd = allNodesCount - k + 1;

        int currentCounter = 1;

        if (k == nodeIndexFromEnd) {
            return head;
        }

        while (node != null) {
            if (currentCounter == k) {
                nodeFromBeg = node;
            }
            if (currentCounter == nodeIndexFromEnd) {
                nodeFromEnd = node;
            }
            currentCounter++;
            node = node.next;
        }

        if (nodeFromBeg == null || nodeFromEnd == null) {
            return head;
        }
        int tempValue = nodeFromBeg.val;
        nodeFromBeg.val = nodeFromEnd.val;
        nodeFromEnd.val = tempValue;

        return head;
    }
}
