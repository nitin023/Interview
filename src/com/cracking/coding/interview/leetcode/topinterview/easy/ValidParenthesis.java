package com.cracking.coding.interview.leetcode.topinterview.easy;

import java.util.Stack;

/**
 * Easy
 * https://leetcode.com/problems/valid-parentheses
 * Stack
 */
public class ValidParenthesis {
    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);

            if (item == '(' || item == '{' || item == '[') {
                stack.push(item);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char poppedChar = stack.pop();
                if (!(poppedChar == '(' && item == ')' || poppedChar == '{' && item == '}' || poppedChar == '[' && item == ']')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
