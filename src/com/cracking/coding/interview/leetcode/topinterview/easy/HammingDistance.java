package com.cracking.coding.interview.leetcode.topinterview.easy;

/**
 * Easy
 * https://leetcode.com/problems/hamming-distance/
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;

        String xorStr = Integer.toBinaryString(xor);

        int count = 0;

        for (int i = 0; i < xorStr.length(); i++) {
            if (xorStr.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }
}
