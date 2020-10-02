package com.cracking.coding.interview.StackAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 3.3 Stack Of Plates
 * HARD
 * https://leetcode.com/problems/dinner-plate-stacks/submissions/
 */
public class DinnerPlates {
    private int count;
    private int left;
    private int right;
    private Map<Integer, Stack<Integer>> stackMap;
    private int capacity;


    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.count = this.left = this.right = 0;
        this.stackMap = new HashMap();
    }

    public void push(int val) {

        while (stackMap.containsKey(left) && stackMap.get(left).size() == capacity) {
            left++;
        }

        stackMap.putIfAbsent(left, new Stack());
        stackMap.get(left).push(val);
        count++;
        right = Math.max(left, right);
    }

    public int pop() {

        if (count == 0) {
            return -1;
        }

        while (right >= 0 && stackMap.get(right).isEmpty()) {
            right--;
        }
        count--;
        int value = stackMap.get(right).pop();
        left = Math.min(left, right);
        return value;
    }

    public int popAtStack(int index) {

        if (count == 0 || !stackMap.containsKey(index) || stackMap.get(index).isEmpty()) {
            return -1;
        }
        int value = stackMap.get(index).pop();
        count--;
        left = Math.min(left, index);
        return value;
    }
}
