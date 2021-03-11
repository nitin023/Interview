package com.cracking.coding.interview.leetcode.topinterview.medium.linkedlist;


import com.cracking.coding.interview.LinkedList.ListNode;
import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 * N2
 */
public class FindSubPath {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != head.val) {
            return false;
        }
        return dfs(root.left, head.next) || dfs(root.right, head.next);
    }
}
