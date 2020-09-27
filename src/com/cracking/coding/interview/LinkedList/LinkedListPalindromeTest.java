package com.cracking.coding.interview.LinkedList;

import java.util.Stack;

/**
 * Easy
 * https://leetcode.com/problems/palindrome-linked-list
 * 2.6 Palindrome test for a singly linked list
 * Solution approach
 * Iterate list using slow and fast pointer
 * this will make slow ptr to reach to middle point of list
 * now use a stack to push all elements of first part of linked list to stack
 * now once slow pointer reaches to start of second list
 * compare each element from list to stack elem
 * if all elem are same then linked list os palindrome
 * else not
 */
public class LinkedListPalindromeTest {
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
