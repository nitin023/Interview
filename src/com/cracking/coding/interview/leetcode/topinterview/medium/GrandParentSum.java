package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class GrandParentSum {
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {

        if (root == null) {
            return sum;
        }
        dfs(root, null, null);

        return sum;
    }

    private void dfs(TreeNode currentNode, TreeNode parentNode, TreeNode grandParentNode) {
        if (currentNode == null) {
            return;
        }

        if (grandParentNode != null && grandParentNode.val % 2 == 0) {
            sum += currentNode.val;
        }

        dfs(currentNode.left, currentNode, parentNode);

        dfs(currentNode.right, currentNode, parentNode);
    }
}
