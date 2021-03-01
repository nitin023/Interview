package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteNodesInLogNTime {
    public int countNodes(TreeNode root) {

        int leftDepth = getDepth(root, 0);

        int rightDepth = getDepth(root, 1);

        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getDepth(TreeNode root, int type) {
        int depth = 0;
        while (root != null) {
            if (type == 0) {
                root = root.left;
            } else
                root = root.right;
            depth++;
        }
        return depth;
    }
}
