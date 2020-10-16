package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumOfRootToLeafBinaryNumbers {
    int binaryPathSum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if(root==null){return 0;}
        getPathSum(root,new ArrayList());
        return binaryPathSum;
    }

    private void getPathSum(TreeNode root , List<Integer> path){
        if(root == null){ return;}
        path.add(root.val);
        if(root.left == null && root.right == null){
            //calculate sum
            calculateSum(path);
            return;
        }
        getPathSum(root.left , new ArrayList(path));
        getPathSum(root.right , new ArrayList(path));
    }

    private void calculateSum(List<Integer>path){
        int maxPower = path.size();

        for(int i = 0  , j = maxPower-1 ; i < maxPower ; i++ , j--)
        {
            binaryPathSum+=Math.pow(2,j) * path.get(i);
        }
    }
}
