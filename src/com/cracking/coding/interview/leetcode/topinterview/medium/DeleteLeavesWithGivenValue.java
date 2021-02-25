package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 */
public class DeleteLeavesWithGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        return deleteLeafNodes(root, target);
    }

    private TreeNode deleteLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = deleteLeafNodes(root.left, target);
        root.right = deleteLeafNodes(root.right, target);

        return root.left == null && root.right == null && root.val == target ? null : root;
    }
}
