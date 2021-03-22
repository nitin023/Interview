package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Medium
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeft {
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.remove();
            if (root.right != null) {
                queue.add(root.right);
            }

            if (root.left != null) {
                queue.add(root.left);
            }
        }

        return root.val;
    }
}
