package com.cracking.coding.interview.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 2.8 Loop Detection
 * Medium
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LoopDetection {

    /**
     * Execution Time is 3ms
     * O(n) Time and O(n) Space
     *
     * @param head
     * @return
     */
    public ListNode detectCycleUsingSet(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode iterator = head;

        Set<ListNode> nodes = new HashSet();

        while (iterator != null) {
            if (nodes.contains(iterator)) {
                return iterator;
            }
            nodes.add(iterator);
            iterator = iterator.next;
        }

        return null;
    }

    /**
     * Execution Time 0ms
     * Fastest solution using Floyd warshall Tortoise- Rabbit algo
     * first check to see a loop exists ot not
     * on validating loop start iterating from head of list
     * to find the start of loop
     * compare this iteration value with fast ptr
     * when the iteration is complete return result
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
