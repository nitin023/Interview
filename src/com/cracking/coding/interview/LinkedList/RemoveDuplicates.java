package com.cracking.coding.interview.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 2.1 Remove Duplicate from singly unsorted linked list
 */
public class RemoveDuplicates {
    /**
     * O(N)Space complexity
     * O(N) Time complexity
     * Best(fastest) Solution possible
     *
     * @param head start pointer
     * @return unique elem linked lists
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<Integer> valueSet = new HashSet();
        ListNode iteratorNode = head, prev = null;

        while (iteratorNode != null) {
            if (valueSet.contains(iteratorNode.val)) {
                prev.next = iteratorNode.next;
            } else {
                valueSet.add(iteratorNode.val);
                prev = iteratorNode;
            }
            iteratorNode = iteratorNode.next;
        }
        return head;
    }

    /**
     * O(N2) Time Complexity
     * O(1) Constant Space Complexity
     *
     * @param head start pointer
     * @return unique elem linked lists
     */
    public ListNode deleteDuplicatesWithoutBuffer(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            ListNode prev = current;
            while (nextNode != null) {
                if (current.val == nextNode.val) {
                    //delete
                    prev.next = nextNode.next;
                    break;
                } else {
                    prev = nextNode;
                }
                nextNode = nextNode.next;
            }
            current = current.next;
        }
        return head;
    }
}
