package com.cracking.coding.interview.TreesAndGraphs;

/**
 * Easy
 * https://leetcode.com/problems/univalued-binary-tree
 */
public class UniValued {
    int univalue ;
    boolean isUniValued = true;
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){return true;}

        univalue = root.val;
        isUniValued = true;
        getInorderTraversal(root);
        return isUniValued;
    }

    private void getInorderTraversal(TreeNode root){

        if(root == null){
            return;
        }
        getInorderTraversal(root.left);
        getInorderTraversal(root.right);
        if(root.val != univalue){
            isUniValued = false;
        }
    }
}
