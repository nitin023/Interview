package com.cracking.coding.interview.leetcode.topinterview.recursion.easy;

import com.cracking.coding.interview.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSequence {

    public TreeNode increasingBST(TreeNode root) {

        if (root == null) {
            return null;
        }
        ArrayList<Integer>traversalList = new ArrayList<>();
        getInorderTraversal(root,traversalList);
        TreeNode skewTree = new TreeNode(traversalList.get(0));
        createSkewTree(1,traversalList.size()-1,traversalList,skewTree);
        return skewTree;
    }

    private void getInorderTraversal(TreeNode node, List<Integer> traversalList) {
        if (node == null) {
            return;
        }
        getInorderTraversal(node.left, traversalList);

        traversalList.add(node.val);
        getInorderTraversal(node.right, traversalList);
    }

    private void createSkewTree(int low , int high , ArrayList<Integer>traversalList, TreeNode skewTree){

        if(low > high){
            return;
        }

        skewTree.right = new TreeNode(traversalList.get(low));
        createSkewTree(low+1,high,traversalList,skewTree.right);
    }
}
