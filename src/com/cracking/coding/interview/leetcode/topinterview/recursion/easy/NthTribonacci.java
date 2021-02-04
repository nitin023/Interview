package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

/**
 * Recursion with memorization
 * Easy
 * https://leetcode.com/problems/n-th-tribonacci-number/submissions/
 */
public class NthTribonacci {
    int[] T = new int[38];

    public int tribonacci(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 3) {
            return 1;
        }

        if (T[n] != 0) {
            return T[n];
        }
        T[n] = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        return T[n];
    }
}
