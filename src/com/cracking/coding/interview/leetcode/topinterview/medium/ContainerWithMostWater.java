package com.cracking.coding.interview.leetcode.topinterview.medium;

/**
 * Two pointer approach
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;

        int length = height.length;
        int l = 0, r = length - 1;

        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
