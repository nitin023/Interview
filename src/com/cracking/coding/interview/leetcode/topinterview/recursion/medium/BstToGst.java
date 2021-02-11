package com.cracking.coding.interview.leetcode.topinterview.recursion.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * Reversed Inorder Traversal
 */
public class BstToGst {
    public  TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGstHelper(root, new TreeNode(0));
        return root;
    }

    private void bstToGstHelper(TreeNode root, TreeNode sum) {
        if (root == null) {
            return;
        }
        bstToGstHelper(root.right, sum);
        sum.val += root.val;
        root.val = sum.val;
        bstToGstHelper(root.left, sum);
    }
}
