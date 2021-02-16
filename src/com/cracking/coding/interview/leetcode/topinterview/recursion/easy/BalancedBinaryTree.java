package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Easy
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {

    private boolean response = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        treeBalancerFinder(root);
        return response;
    }

    private void treeBalancerFinder(TreeNode root) {
        if (root == null) {
            return;
        }

        int heightDiff = Math.abs(getTreeHeight(root.left) - getTreeHeight(root.right));
        if (heightDiff > 1) {
            response = false;
            return;
        }
        treeBalancerFinder(root.left);
        treeBalancerFinder(root.right);
    }

    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
    }
}
