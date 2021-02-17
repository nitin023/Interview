package com.cracking.coding.interview.leetcode.topinterview.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Easy
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || isLeafNode(root)) {
            return 0;
        }
        getSumOfLeftLeaves(root, null);
        return sum;
    }

    private int sum = 0;

    private void getSumOfLeftLeaves(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (isLeafNode(root)) {
            if (parent.left == root) {
                sum += root.val;
            }
        }
        getSumOfLeftLeaves(root.left, root);

        getSumOfLeftLeaves(root.right, root);
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
