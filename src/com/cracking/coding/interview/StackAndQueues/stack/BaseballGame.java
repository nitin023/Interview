package com.cracking.coding.interview.StackAndQueues.stack;

import java.util.Stack;

/**
 * Easy
 * https://leetcode.com/problems/baseball-game/submissions/
 */
public class BaseballGame {

    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();

        for (String element : ops) {
            if (element.equals("+")) {
                int firstElement = stack.pop();
                int secondElement = stack.pop();
                int sum = firstElement + secondElement;

                stack.push(secondElement);
                stack.push(firstElement);
                stack.push(sum);
            } else if (element.equals("C")) {
                stack.pop();
            } else if (element.equals("D")) {
                int value = stack.peek() * 2;
                stack.push(value);
            } else {
                stack.push(Integer.parseInt(element));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
