package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/binary-tree-pruning/
 */
public class PruneBinaryTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        return helper(root);
    }

    private TreeNode helper(TreeNode root) {

        if (root == null) {
            return null;
        }

        root.left = helper(root.left);

        root.right = helper(root.right);

        return root.left == null && root.right == null && root.val == 0 ? null : root;
    }
}
