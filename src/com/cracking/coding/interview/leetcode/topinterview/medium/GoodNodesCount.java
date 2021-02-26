package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree
 */
public class GoodNodesCount {

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getGoodNodesCountHelper(root, -10000);
    }

    private int getGoodNodesCountHelper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int result = root.val >= max ? 1 : 0;
        result += getGoodNodesCountHelper(root.left, Math.max(max, root.val));
        result += getGoodNodesCountHelper(root.right, Math.max(max, root.val));
        return result;
    }
}
