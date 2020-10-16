package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * https://leetcode.com/problems/increasing-order-search-tree
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> inorderTraversal = new ArrayList();
        getInorderTraversal(root, inorderTraversal);
        return getTree(inorderTraversal);
    }

    private void getInorderTraversal(TreeNode root, List<Integer> inorderTraversal) {
        if (root == null) {
            return;
        }

        getInorderTraversal(root.left, inorderTraversal);
        inorderTraversal.add(root.val);
        getInorderTraversal(root.right, inorderTraversal);
    }

    private TreeNode getTree(List<Integer> inorderTraversal) {
        TreeNode root = new TreeNode(inorderTraversal.get(0));
        final TreeNode rootCopy = root;

        for (int i = 1; i < inorderTraversal.size(); i++) {
            root.right = new TreeNode(inorderTraversal.get(i));
            root = root.right;
        }

        return rootCopy;
    }
}
