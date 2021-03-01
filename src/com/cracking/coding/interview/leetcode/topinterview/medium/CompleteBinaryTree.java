package com.cracking.coding.interview.leetcode.topinterview.medium;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Medium
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 */
public class CompleteBinaryTree {

    public static  boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) end = true;
            else {
                if (end) return false;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return true;
    }
}
