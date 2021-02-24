package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/deepest-leaves-sum/
 */
public class DeepestLevelSum {
    int maxLevel = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level > maxLevel) {
            maxLevel = level;
            sum = 0;
        }

        if (level == maxLevel) {
            sum += root.val;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
