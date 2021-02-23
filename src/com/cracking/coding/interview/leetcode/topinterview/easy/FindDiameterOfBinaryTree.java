package com.cracking.coding.interview.leetcode.topinterview.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Easy
 * https://leetcode.com/problems/diameter-of-binary-tree
 * Use height principle to determine max path length
 */
public class FindDiameterOfBinaryTree {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return ans;
    }

    private int findDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubtreeDepth = findDiameter(root.left);

        int rightSubtreeDepth = findDiameter(root.right);

        ans = Math.max(leftSubtreeDepth + rightSubtreeDepth, ans);

        return Math.max(leftSubtreeDepth, rightSubtreeDepth) + 1;
    }
}
