package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 * Easy
 */
public class FindPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || targetSum < 1) {
            return false;
        }
        return findPathSum(root, targetSum);
    }

    private boolean findPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }
        return findPathSum(root.left, targetSum - root.val) || findPathSum(root.right, targetSum - root.val);
    }
}
