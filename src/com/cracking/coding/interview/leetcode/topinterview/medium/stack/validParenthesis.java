package com.cracking.coding.interview.leetcode.topinterview.medium.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class validParenthesis {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char parenthesis = s.charAt(i);
            if (parenthesis == '(' || parenthesis == '{' || parenthesis == '[') {
                stack.add(parenthesis);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char closingParenthesis = stack.pop();
                if (parenthesis == ')' && (closingParenthesis == '{' || closingParenthesis == '[') ||
                        parenthesis == '}' && (closingParenthesis == '[' || closingParenthesis == '(') ||
                        parenthesis == ']' && (closingParenthesis == '{' || closingParenthesis == '(')
                ) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
