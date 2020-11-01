package com.cracking.coding.interview.TreesAndGraphs;

/**
 * Easy
 * https://leetcode.com/problems/invert-binary-tree
 */
public class InvertTrees {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){return null;}
        return invertTreeHelper(root);
    }

    private TreeNode invertTreeHelper(TreeNode root){

        if(root == null){return null;}

        TreeNode nodeLeft = root.left;
        root.left = root.right;
        root.right = nodeLeft;

        invertTreeHelper(root.left);
        invertTreeHelper(root.right);

        return root;
    }
}
