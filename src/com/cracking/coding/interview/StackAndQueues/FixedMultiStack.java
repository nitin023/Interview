package com.cracking.coding.interview.StackAndQueues;

/**
 * 3.1
 * Medium
 */
public class FixedMultiStack {

    private final int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        this.stackCapacity = stackSize;
        values = new int[numberOfStacks * stackSize];
        this.sizes = new int[stackSize];
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            throw new RuntimeException("Stack with number " + stackNum + " is full");
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new RuntimeException("Stack with number " + stackNum + " is empty");
        }
        int poppedElement = values[indexOfTop(stackNum)];
        values[indexOfTop(stackNum)] = 0;
        sizes[stackNum]--;
        return poppedElement;
    }

    private boolean isFull(int index) {
        return sizes[index] == stackCapacity;
    }

    private boolean isEmpty(int index) {
        return sizes[index] == 0;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    private int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new RuntimeException("Stack with number " + stackNum + " is empty");
        }
        return values[indexOfTop(stackNum)];
    }
}
