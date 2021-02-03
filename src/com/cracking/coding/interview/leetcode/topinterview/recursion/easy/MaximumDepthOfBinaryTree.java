package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.time.temporal.Temporal;

/**
 * Easy
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        maxDepth(node);
    }

    public static int maxDepth(TreeNode root) {

        return maxDepthHelper(root);
    }

    private static int maxDepthHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepthHelper(root.left);

        int rightHeight = maxDepthHelper(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
