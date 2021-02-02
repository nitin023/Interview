package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;

/**
 * Easy
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumInBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        ArrayList<Integer>arr = new ArrayList<>();
        if (root == null) {
            return 0;
        }

        helper(root, low, high);
        return sum;
    }

    private void helper(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if (high >= root.val) {
            helper(root.right, low, high);
        }

        if (low <= root.val) {
            helper(root.left, low, high);
        }
    }

}
