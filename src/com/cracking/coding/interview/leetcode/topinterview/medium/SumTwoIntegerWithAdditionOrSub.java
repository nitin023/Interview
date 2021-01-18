package com.cracking.coding.interview.leetcode.topinterview.medium;

/**
 *Medium
 * https://leetcode.com/problems/sum-of-two-integers/
 * Using Bitwise operation
 */
public class SumTwoIntegerWithAdditionOrSub {
    public int getSum(int a, int b) {
        int c;
        while (b != 0) {
            c = (a & b);
            a = a ^ b;
            b = (c) << 1;
        }
        return a;
    }
}