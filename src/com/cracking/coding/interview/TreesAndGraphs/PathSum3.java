package com.cracking.coding.interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSum3 {

    private static int count = 0;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode n1 = new TreeNode(4);
        root.left.left = n1;
        root.left.right = new TreeNode(5);
        TreeNode n2 = new TreeNode(8);
        root.left.right.right = n2;
        root.left.right.left = new TreeNode(7);
        pathSum(root,6);
    }

    private static int pathSum(TreeNode root , int sum){
        if(root == null){
            return 0;
        }
        getPathSumCount(root,sum);
        return count;
    }

    private static void getPathSumCount(TreeNode root , int sum)
    {
        if(root == null){
            return;
        }

        list.add(root.val);
        getPathSumCount(root.left , sum);
        getPathSumCount(root.right , sum);

        int temp = 0;
        for(int i = list.size() - 1 ; i >= 0 ;i--)
        {
            temp+= list.get(i);
            if(temp == sum){
                count++;
            }
        }
        list.remove(list.size()-1);
    }
}
