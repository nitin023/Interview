package com.cracking.coding.interview.leetcode.topinterview.medium.tree;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

/**
 * Medium
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class ConstructTreeFromPostAndPreOrderTraversal {


    public static void main(String[] args) {
        constructFromPrePost(new int[]{1,2,4,5,3,6,7},new int[]{4,5,2,6,7,3,1});
    }
    static int preIndex = 0, postIndex = 0;

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length == 0 || post.length == 0) {
            return null;
        }
        return constructTreeHelper(pre, post);
    }

    private static TreeNode constructTreeHelper(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);

        if (root.val != post[postIndex]) {
            root.left = constructFromPrePost(pre, post);
        }
        if (root.val != post[postIndex]) {
            root.right = constructFromPrePost(pre, post);
        }
        postIndex++;
        return root;
    }
}
