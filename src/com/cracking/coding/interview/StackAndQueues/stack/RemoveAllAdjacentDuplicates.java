package com.cracking.coding.interview.StackAndQueues.stack;

import java.util.Stack;

/**
 * Easy
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/
 */
public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char currentItem = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(currentItem);
            } else {
                char stackTopElement = stack.peek();
                if (currentItem == stackTopElement) {
                    stack.pop();
                } else {
                    stack.add(currentItem);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
