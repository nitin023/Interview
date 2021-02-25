package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructBSTFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode rootNode = null;

        for (int j : preorder) {
            rootNode = insertIntoBST(rootNode, j);
        }
        return rootNode;
    }

    private TreeNode insertIntoBST(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertIntoBST(node.left, val);
        } else {
            node.right = insertIntoBST(node.right, val);
        }

        return node;
    }
}
