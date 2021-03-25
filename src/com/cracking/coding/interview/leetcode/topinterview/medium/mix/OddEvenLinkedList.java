package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

import com.cracking.coding.interview.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/odd-even-linked-list/
 * To solve in place
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(7);
        oddEvenList(node);
    }

    /**
     * Interesting approach to solve problem in-place
     * We have to iterate over the entire list considering only even or odd nodes
     * and attaching those nodes to one another for solution
     * after that attach odd node next to even node head
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


}
