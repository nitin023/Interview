package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Easy
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        return minDepthFinder(root);
    }

    private int minDepthFinder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minLeft = minDepthFinder(root.left);

        int minRight = minDepthFinder(root.right);

        return (minRight == 0 || minLeft == 0) ? minLeft + minRight + 1 : Math.min(minLeft, minRight) + 1;
    }
}
