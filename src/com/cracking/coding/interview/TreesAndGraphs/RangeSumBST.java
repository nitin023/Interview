package com.cracking.coding.interview.TreesAndGraphs;

/**
 * Easy
 * https://leetcode.com/problems/range-sum-of-bst/submissions/
 */
public class RangeSumBST {

    int count = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {

        if(root == null) {return 0;}

        helperRangeSumBST(root,L,R);
        return count;
    }

    private void helperRangeSumBST(TreeNode root, int L, int R)
    {
        if(root == null){return;}

        helperRangeSumBST(root.left,L,R);
        if(L<=root.val && root.val <=R){count+=root.val;}
        helperRangeSumBST(root.right,L,R);
    }
}
