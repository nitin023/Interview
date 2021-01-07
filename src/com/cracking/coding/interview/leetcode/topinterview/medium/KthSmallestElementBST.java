package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * O(N)
 * Medium
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return 0;
        }

        List<Integer> inorderTraversal = new ArrayList();
        getInorderTraversal(root, inorderTraversal);
        return inorderTraversal.get(k - 1);
    }

    private void getInorderTraversal(TreeNode root, List<Integer> inorderTraversal) {

        if (root == null) {
            return;
        }
        getInorderTraversal(root.left, inorderTraversal);
        inorderTraversal.add(root.val);
        getInorderTraversal(root.right, inorderTraversal);
    }
}
