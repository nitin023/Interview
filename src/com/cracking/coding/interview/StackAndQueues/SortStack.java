package com.cracking.coding.interview.StackAndQueues;

import java.util.Stack;

/**
 * Medium
 * 3.5 Sort Stack only using another stack
 */
public class SortStack {
    private Stack<Integer> primary;

    public SortStack() {
        primary = new Stack();
    }

    public Integer peek() {
        if (primary.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return primary.peek();
    }

    public Integer pop() {
        if (primary.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return primary.pop();
    }

    public void push(Integer value) {
        if (primary.isEmpty()) {
            primary.push(value);
        } else {
            int topElem = primary.peek();
            if (value <= topElem) {
                primary.push(value);
            } else {
                Stack<Integer> secondary = new Stack();
                while (!primary.isEmpty()) {
                    secondary.push(primary.pop());
                }
                primary.push(value);
                while (!secondary.isEmpty()) {
                    primary.push(secondary.pop());
                }
            }
        }
    }

    /**
     * This is to sort a given stack in following manner
     * 1. Iterate over given stack
     * 2. Compare secondary stack top with current top
     * 3. If secondary stack top is greater than current top then pop all elem from secondary stack
     * 4. Else add the element to secondary stack
     * 5. At last we will get sorted stack in descending order
     * @param s
     * @return
     */
    public Stack<Integer> sortStack(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int currentTop = s.pop();
            while (!r.isEmpty() && r.peek() > currentTop) {
                s.push(r.pop());
            }
            r.push(currentTop);
        }
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
        return s;
    }
}
