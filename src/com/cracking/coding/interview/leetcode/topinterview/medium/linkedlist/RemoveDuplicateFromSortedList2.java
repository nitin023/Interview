package com.cracking.coding.interview.leetcode.topinterview.medium.linkedlist;

import com.cracking.coding.interview.LinkedList.ListNode;

import java.util.ArrayList;

/**
 * Medium
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicateFromSortedList2 {

    public  ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return deleteDuplicateHelper(head);
    }

    private  ListNode deleteDuplicateHelper(ListNode head) {

        ArrayList<Integer> validElements = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            int counter = 1;
            while (q!=null && p.val == q.val) {
                q = q.next;
                counter++;
            }
            if (counter == 1) {
                validElements.add(p.val);
            }
            p = q;
        }

        if(validElements.size()==0){
            return null;
        }

        ListNode newHead = new ListNode(validElements.get(0));
        ListNode nextNode = newHead;
        for(int i = 1 ; i < validElements.size() ; i++){
            nextNode.next = new ListNode(validElements.get(i));
            nextNode = nextNode.next;
        }
        return newHead;
    }
}
