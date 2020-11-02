package com.cracking.coding.interview.TreesAndGraphs;

/**
 * 669. Trim a Binary Search Tree
 * Medium
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return trimBSTHelper(root, low, high);
    }

    private TreeNode trimBSTHelper(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBSTHelper(root.right, low, high);
        }

        if (root.val > high) {
            return trimBSTHelper(root.left, low, high);
        }

        root.left = trimBSTHelper(root.left, low, high);

        root.right = trimBSTHelper(root.right, low, high);

        return root;
    }
}
