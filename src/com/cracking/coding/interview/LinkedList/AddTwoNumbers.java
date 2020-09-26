package com.cracking.coding.interview.LinkedList;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }

        ListNode headNode = null, tail = null;
        int prevCarry = 0;
        while (l1 != null || l2 != null) {
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;
            int sum = l1Value + l2Value + prevCarry;

            if (sum > 9) {
                prevCarry = 1;
                sum -= 10;
            } else {
                prevCarry = 0;
            }

            if (headNode == null) {
                headNode = new ListNode(sum);
                tail = headNode;
            } else {
                tail = addSumInNode(tail, sum);
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (prevCarry == 1) {
            tail.next = new ListNode(1);
            tail = tail.next;
        }
        return headNode;
    }

    private ListNode addSumInNode(ListNode tail, int sum) {
        tail.next = new ListNode(sum);
        tail = tail.next;
        return tail;
    }
}
