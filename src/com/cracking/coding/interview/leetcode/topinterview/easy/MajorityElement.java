package com.cracking.coding.interview.leetcode.topinterview.easy;

/**
 * Easy
 * https://leetcode.com/problems/majority-element/
 * Moore’s Voting Algorithm O(n) constant space
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = findCandidate(nums, nums.length);
        if (isMajority(nums, nums.length, candidate)) {
            return candidate;
        }
        return -1;
    }

    private int findCandidate(int a[], int size) {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    private boolean isMajority(int[] a, int size, int cand) {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (a[i] == cand)
                count++;
        }
        return count > size / 2;
    }
}
