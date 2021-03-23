package com.cracking.coding.interview.leetcode.topinterview.medium.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Medium
 * https://leetcode.com/problems/next-greater-element-i/
 * Monotone stack common problem
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numToNextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                numToNextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = numToNextGreaterMap.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
