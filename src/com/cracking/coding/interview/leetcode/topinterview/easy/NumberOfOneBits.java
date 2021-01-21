package com.cracking.coding.interview.leetcode.topinterview.easy;

/**
 * Easy
 * https://leetcode.com/problems/number-of-1-bits
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        String item = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < item.length(); i++) {
            if (item.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
