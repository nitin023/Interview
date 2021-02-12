package com.cracking.coding.interview.leetcode.topinterview.recursion.medium;

/**
 * Medium
 * https://leetcode.com/problems/jump-game-iii/
 * Iterating over array and also marking visited nodes for preventing stack overflow
 */
public class JumpGame3 {
    private boolean canReach(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] < arr.length) {
            int jump = arr[start];
            arr[start] += arr.length;
            return jump == 0 || canReach(arr, start + jump) || canReach(arr, start - jump);
        }
        return false;
    }
}