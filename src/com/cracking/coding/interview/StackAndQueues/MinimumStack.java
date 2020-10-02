package com.cracking.coding.interview.StackAndQueues;

/**
 * Easy
 * Runtime 3 ms
 * 3.2 Minimum Element In Stack
 */
public class MinimumStack {
    private final int MAX_CAPACITY;
    private int top;
    private int[] stack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinimumStack() {
        this.MAX_CAPACITY = 1000;
        this.stack = new int[this.MAX_CAPACITY];
        this.top = -1;
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {

        if (!isFull()) {
            stack[++top] = x;
            min = Math.min(min, x);
        }
    }

    public void pop() {
        if (!isEmpty()) {
            int removedElem = stack[top--];
            if (removedElem == min) {
                getNewMinimum();
            }
        }
    }

    public int top() {
        if (!isEmpty()) {
            return stack[top];
        }
        return -1;
    }

    public int getMin() {
        return min;
    }

    private boolean isFull() {
        return top == MAX_CAPACITY - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void getNewMinimum() {
        int newMin = Integer.MAX_VALUE;
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                newMin = Math.min(newMin, stack[i]);
            }
        }
        min = newMin;
    }
}
