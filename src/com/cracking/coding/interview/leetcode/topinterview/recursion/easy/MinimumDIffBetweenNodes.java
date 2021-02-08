package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Easy
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes
 */
public class MinimumDIffBetweenNodes {
    private Integer min = Integer.MAX_VALUE;
    private Integer pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minimumDiffHelper(root);
        return min;
    }

    private void minimumDiffHelper(TreeNode root) {
        if (root.left != null) {
            minimumDiffHelper(root.left);
        }
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        if (root.right != null) {
            minimumDiffHelper(root.right);
        }
    }
}
