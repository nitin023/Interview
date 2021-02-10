package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Easy
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {

    private int sum = 0;

    public int findTilt(TreeNode root) {
        return tiltFinder(root);
    }

    private int tiltFinder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isLeaf(root)) {
            return root.val;
        }
        int leftSum = tiltFinder(root.left);
        int rightSum = tiltFinder(root.right);
        sum += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
