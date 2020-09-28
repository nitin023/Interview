package com.cracking.coding.interview.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {

    /**
     * Runtime Exec : 1 Ms
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        List<Integer> smallList = new ArrayList();
        List<Integer> largeList = new ArrayList();

        getPartitionedList(head, x, smallList, largeList);
        return getPartitionedListNode(smallList, largeList);
    }

    private void getPartitionedList(ListNode head, int x, List<Integer> smallList, List<Integer> largeList) {
        ListNode iterator = head;
        while (iterator != null) {
            if (iterator.val < x) {
                smallList.add(iterator.val);
            } else {
                largeList.add(iterator.val);
            }
            iterator = iterator.next;
        }
    }

    /**
     * Leet code solution more fast
     * @param smallList
     * @param largeList
     * @return
     */
    private ListNode getPartitionedListNode(List<Integer> smallList, List<Integer> largeList) {
        ListNode partitedList = null, headNode = null;

        for (int item : smallList) {
            if (headNode == null) {
                partitedList = new ListNode(item);
                headNode = partitedList;
            } else {
                partitedList.next = new ListNode(item);
                partitedList = partitedList.next;
            }

        }

        for (int item : largeList) {
            if (headNode == null) {
                partitedList = new ListNode(item);
                headNode = partitedList;
            } else {
                partitedList.next = new ListNode(item);
                partitedList = partitedList.next;
            }

        }
        return headNode;
    }

    public ListNode getPartition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }
}
