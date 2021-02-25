package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        root = getInsertedNode(root, val);
        return root;
    }

    private TreeNode getInsertedNode(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = getInsertedNode(root.left, val);
        } else {
            root.right = getInsertedNode(root.right, val);
        }
        return root;
    }
}
